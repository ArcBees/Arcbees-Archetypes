package com.arcbees.project.client.application.admin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class AdminModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(AdminPresenter.class, AdminPresenter.MyView.class, AdminView.class, AdminPresenter.MyProxy.class);
    }
}
