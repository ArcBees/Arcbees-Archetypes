package com.arcbees.myproject.client.gin;

import com.arcbees.myproject.client.application.ApplicationModule;
import com.arcbees.myproject.client.place.ClientPlaceManager;
import com.arcbees.myproject.client.place.DefaultPlace;
import com.arcbees.myproject.client.place.NameTokens;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule(ClientPlaceManager.class));
        install(new ApplicationModule());

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
    }
}
