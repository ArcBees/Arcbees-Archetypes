package com.arcbees.project.client.application;


import com.arcbees.project.client.application.admin.AdminModule;
import com.arcbees.project.client.application.home.HomeModule;
import com.arcbees.project.client.application.widget.WidgetModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new WidgetModule());
        install(new AdminModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
