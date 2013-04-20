package ${package}.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileIntegrationGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "${package}.IntegrationTesting";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
