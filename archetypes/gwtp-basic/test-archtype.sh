#!/bin/sh
# Test import archetype

mvn clean
mkdir -p target/test
cd target/test

mvn archetype:generate -DarchetypeGroupId=com.arcbees.archetypes \
-DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots/ \
-DarchetypeArtifactId=gwtp-basic-archetype \
-DarchetypeVersion=1.0-SNAPSHOT \
-DgroupId=com.projectname \
-DartifactId=new-project-name \
-Dmodule=Project \
-DinteractiveMode=false
