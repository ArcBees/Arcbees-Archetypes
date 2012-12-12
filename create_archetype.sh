#!/bin/sh
# Generate a new archetype using this project as a template.
# Once the archetype has been created run 'mvn archetype:generate -DarchetypeCatalog=local' in a new directory
# http://www.automatedbusinesslogic.com/articles/deploying-a-maven-archetype

echo "Started"

CURRENTDIR=`pwd`

# TODO add parameter to change type
PROJECTDIR=$CURRENTDIR/archetype-gwtp-basic-appengine

# move to the archetype
cd $PROJECTDIR

# clean house
mvn clean
mvn idea:clean
mvn eclipse:clean
rm -R .settings
rm -R bin

echo "mvn archetype:create-from-project"
mvn archetype:create-from-project

cd target/generated-sources/archetype/
mvn install

# produce a catalog
#mvn archetype:crawl -Dcatalog=$CURRENTDIR/archetype-catalog.xml

# work around b/c com.arcbees inherits conflicts
cd target/generated-sources/archetype/
find . -name '*.xml' -type f -exec sed -i '' 's/${groupId}.core/com.arcbees.core/g' {} \;
find . -name '*.java' -type f -exec sed -i '' 's/${groupId}.core/com.arcbees.core/g' {} \;

cd $CURRENTDIR

# add deployment to pom.xml for deployment to sonatype
SONATYPE="<distributionManagement><repository><id>sona-nexus-deploy<\/id><url>https:\/\/oss.sonatype.org\/service\/local\/staging\/deploy\/maven2<\/url><\/repository><snapshotRepository><id>sona-nexus-deploy<\/id><url>https:\/\/oss.sonatype.org\/content\/repositories\/snapshots<\/url><\/snapshotRepository><\/distributionManagement><\/project>"
echo $SONATYPE

sed -ie "s@<\/project>@${SONATYPE}@g" $PROJECTDIR/target/generated-sources/archetype/pom.xml
cd $PROJECTDIR/target/generated-sources/archetype
mvn deploy

echo "Finished"

echo "\n***Run this in a new project directory:***\nmvn archetype:generate -DarchetypeCatalog=local\n"
