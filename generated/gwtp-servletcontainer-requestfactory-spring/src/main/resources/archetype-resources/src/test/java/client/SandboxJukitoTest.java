#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package}.client;

import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JukitoRunner.class)
public class SandboxJukitoTest {
    public static class Module extends JukitoModule {
        @Override
        protected void configureTest() {
        }
    }

    @Test
    public void testSandbox() {
        assertTrue(true);
    }
}
