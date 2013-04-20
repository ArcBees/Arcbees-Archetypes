package com.arcbees.project.client.application.widget;

import com.arcbees.project.client.application.widget.header.HeaderModule;
import com.arcbees.project.client.application.widget.login.LoginModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WidgetModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HeaderModule());
        install(new LoginModule());
    }
}
