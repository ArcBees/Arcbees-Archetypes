/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.inject.Provider;
import com.arcbees.myproject.client.common.AppPresenter;
import com.arcbees.myproject.client.main.MainPagePresenter;
import com.arcbees.myproject.client.main.ResponsePresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

  EventBus getEventBus();

  PlaceManager getPlaceManager();

  Provider<MainPagePresenter> getMainPagePresenter();

  Provider<ResponsePresenter> getResponsePresenter();

  Provider<AppPresenter> getAppPresenter();
}
