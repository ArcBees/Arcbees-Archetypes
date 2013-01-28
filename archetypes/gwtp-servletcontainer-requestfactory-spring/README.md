#GWTP Servlet Container using RequestFactory

GWTP using a generic servlet container using RequestFactory and Spring.

##Highlights
* [Client Server Directories](https://github.com/ArcBees/ArcBees-tools/tree/master/archetypes/gwtp-servletcontainer-requestfactory-spring/src/main/java/com/arcbees/project)
* [GWT Module](https://github.com/ArcBees/ArcBees-tools/blob/master/archetypes/gwtp-servletcontainer-requestfactory-spring/src/main/java/com/arcbees/myproject/Project.gwt.xml)
* [Tests](https://github.com/ArcBees/ArcBees-tools/tree/master/archetypes/gwtp-servletcontainer-requestfactory-spring/src/test/java/com/arcbees/project/client)

##Maven Archetype Usage

1. Goto directory you want the project.
2. Rename parameter below `com.projectname.project` to a package naming scheme you like.
3. Rename parameter `new-project-name` to a project title you like.
4. Run the mvn archetype generator below.

* This project Project.gwt.xml module name is hard coded and will will not be changed from the parameters below at this time.

```
mvn archetype:generate -DarchetypeGroupId=com.arcbees.archetypes \
-DarchetypeRepository=https://oss.sonatype.org/content/repositories/snapshots/ \
-DarchetypeArtifactId=gwtp-servletcontainer-requestfactory-spring-archetype \
-DarchetypeVersion=1.0-SNAPSHOT \
-DgroupId=com.projectname \
-DartifactId=new-project-name 
```
