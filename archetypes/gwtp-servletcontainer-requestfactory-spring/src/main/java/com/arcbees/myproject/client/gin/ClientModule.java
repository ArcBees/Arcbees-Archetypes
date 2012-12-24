/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.myproject.client.gin;


import com.arcbees.myproject.client.application.ApplicationModule;
import com.arcbees.myproject.client.place.DefaultPlace;
import com.arcbees.myproject.client.place.NameTokens;
import com.arcbees.myproject.client.place.PlaceManager;
import com.arcbees.myproject.client.request.MyRequestFactory;
import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule(PlaceManager.class));
        install(new ApplicationModule());

        bind(MyRequestFactory.class).toProvider(RequestFactoryProvider.class).in(Singleton.class);
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
    }

    static class RequestFactoryProvider implements Provider<MyRequestFactory> {
        private final MyRequestFactory requestFactory;

        @Inject
        public RequestFactoryProvider(EventBus eventBus) {
            requestFactory = GWT.create(MyRequestFactory.class);
            requestFactory.initialize(eventBus);
        }

        public MyRequestFactory get() {
            return requestFactory;
        }
    }
}
