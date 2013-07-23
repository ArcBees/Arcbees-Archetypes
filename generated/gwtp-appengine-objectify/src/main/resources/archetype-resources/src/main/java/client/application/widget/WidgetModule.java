#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.widget;

import ${package}.client.application.widget.header.HeaderModule;
import ${package}.client.application.widget.login.LoginModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WidgetModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HeaderModule());
        install(new LoginModule());
    }
}
