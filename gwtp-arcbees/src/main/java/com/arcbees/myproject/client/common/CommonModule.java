/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */

package com.arcbees.myproject.client.common;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class CommonModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    bindPresenter(AppPresenter.class, AppPresenter.MyView.class, AppView.class, AppPresenter.MyProxy.class);
  }
}
