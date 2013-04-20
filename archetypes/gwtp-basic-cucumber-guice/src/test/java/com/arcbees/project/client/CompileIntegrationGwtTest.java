package com.arcbees.project.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileIntegrationGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.arcbees.project.IntegrationTesting";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
