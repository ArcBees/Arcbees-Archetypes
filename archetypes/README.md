#Arcbees Tools

#More about  [GWTP](https://github.com/ArcBees/GWTP)

##Community Help
* [Join the GWT-Platform G+ Community](https://plus.google.com/communities/113139554133824081251)

##License
* GWTP is freely distributable under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html)

##Create Project
* To create a GWTP basic App Engine project change the groupId and artifactId. 

  ```
  mvn archetype:generate -DarchetypeGroupId=com.arcbees \
  -DarchetypeArtifactId=gwtp-appengine-basic \
  -DarchetypeVersion=0.1-SNAPSHOT \
  -DgroupId=com.projectname \
  -DartifactId=new-project-name \
  -DremoteRepositories=https://oss.sonatype.org/content/repositories/snapshots/
  ```

##Archetype Creation
* run 'sh ./create_archetype.sh'
* Goto a new project directory
* run 'mvn archetype:generate -DarchetypeCatalog=local'

##Reference
* [Archetype Guide](http://maven.apache.org/guides/mini/guide-creating-archetypes.html)

##Thanks to
[![Arcbees.com](http://arcbees-ads.appspot.com/images/1.png)](http://arcbees.com)

[![IntelliJ](https://lh6.googleusercontent.com/--QIIJfKrjSk/UJJ6X-UohII/AAAAAAAAAVM/cOW7EjnH778/s800/banner_IDEA.png)](http://www.jetbrains.com/idea/index.html)
