/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.arcbees.myproject.client.place.ClientPlaceManager;
import com.arcbees.myproject.client.core.MainPagePresenter;
import com.arcbees.myproject.client.core.MainPageView;
import com.arcbees.myproject.client.place.DefaultPlace;
import com.arcbees.myproject.client.place.NameTokens;
import com.arcbees.myproject.client.core.ResponsePresenter;
import com.arcbees.myproject.client.core.ResponseView;

public class ClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    install(new DefaultModule(ClientPlaceManager.class));

    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
        MainPageView.class, MainPagePresenter.MyProxy.class);

    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.main);

    bindPresenter(ResponsePresenter.class, ResponsePresenter.MyView.class,
        ResponseView.class, ResponsePresenter.MyProxy.class);
  }
}
