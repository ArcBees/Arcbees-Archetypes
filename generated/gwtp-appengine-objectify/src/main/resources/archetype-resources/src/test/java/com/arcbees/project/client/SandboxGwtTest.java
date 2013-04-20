package com.arcbees.project.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.arcbees.project.${module}";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
