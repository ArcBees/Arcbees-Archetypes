package com.arcbees.archetypes.generator;

import java.util.ArrayList;
import java.util.List;

import org.gonevertical.archetypes.generator.GwtArchetypeGenerator;

public class RunProjectToArchetypeGenerator {

  public static void main(String[] args) {
    new RunProjectToArchetypeGenerator().run();
  }

  private void run() {
    
    
    // TODO feed in replacements
    // s/${groupId}.core/com.arcbees.core/g
    // s/${groupId}.core/com.arcbees.core/g
    // s/<module>.*\.\(.*\)<\/module>/<module>${package}.\1<\/module>/g

   
    List<String> projects = new ArrayList<String>();
    projects.add("gwtp-basic");
    //projects.add("gwtp-appengine-basic");
    //projects.add("gwtp-appengine-objectify");
    //projects.add("gwtp-servletcontainer-requestfactory-spring");
    
    GwtArchetypeGenerator generate = new GwtArchetypeGenerator();
    generate.setProjects(projects);
    generate.setDeploy(false);
    generate.run();
  }

}
