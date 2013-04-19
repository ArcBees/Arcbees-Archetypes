package com.arcbees.archetypes.generator;

import java.util.ArrayList;
import java.util.List;

import org.gonevertical.archetypes.generator.GwtArchetypeGenerator;
import org.gonevertical.archetypes.generator.domain.FindInReplace;

public class RunProjectToArchetypeGenerator {

  public static void main(String[] args) {
    new RunProjectToArchetypeGenerator().run();
  }

  private void run() {
    // TODO not needed at the moment
    List<FindInReplace> findInReplaceList = new ArrayList<FindInReplace>();
    //findInReplaceList.add(new FindInReplace("*.xml", "\\${groupId}.core", "com.arcbees.core"));
    //findInReplaceList.add(new FindInReplace("*.java", "\\${groupId}.core", "com.arcbees.core"));
   
    List<String> projects = new ArrayList<String>();
    projects.add("gwtp-basic");
    //projects.add("gwtp-appengine-basic");
    //projects.add("gwtp-appengine-objectify");
    //projects.add("gwtp-servletcontainer-requestfactory-spring");
    
    GwtArchetypeGenerator generate = new GwtArchetypeGenerator();
    generate.setProjects(projects);
    generate.setDeploy(false);
    generate.setFindInReplace(findInReplaceList);
    generate.run();
  }

}
