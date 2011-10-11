/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.arcbees.myproject.client.common.CommonModule;
import com.arcbees.myproject.client.main.MainModule;
import com.arcbees.myproject.client.place.ClientPlaceManager;
import com.arcbees.myproject.client.place.DefaultPlace;
import com.arcbees.myproject.client.place.NameTokens;

public class ClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    install(new DefaultModule(ClientPlaceManager.class));
    install(new CommonModule());
    install(new MainModule());

    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.main);
  }
}
