/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */

package com.arcbees.myproject.client.main;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MainModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    bindPresenter(ResponsePresenter.class, ResponsePresenter.MyView.class,
        ResponseView.class, ResponsePresenter.MyProxy.class);
    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
        MainPageView.class, MainPagePresenter.MyProxy.class);
  }
}
