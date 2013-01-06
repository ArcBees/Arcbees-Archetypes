package com.arcbees.project.client.gin;

import com.arcbees.project.client.BootStrapper;
import com.arcbees.project.client.application.ApplicationPresenter;
import com.arcbees.project.client.application.home.HomePagePresenter;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface AppGinjector extends Ginjector {
    BootStrapper getBootStrapper();
    
    EventBus getEventBus();

    PlaceManager getPlaceManager();

    Provider<ApplicationPresenter> getAppPresenter();
    
    Provider<HomePagePresenter> getHomePagePresenter();
}
