package tld.domain.tasks.client.application.widget;

import tld.domain.tasks.client.application.widget.header.HeaderModule;
import tld.domain.tasks.client.application.widget.login.LoginModule;

import com.google.gwt.inject.client.AbstractGinModule;

public class WidgetModule extends AbstractGinModule {
    @Override
    protected void configure() {
        install(new HeaderModule());
        install(new LoginModule());
    }
}
