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

package com.arcbees.project.client.gin;

import javax.inject.Singleton;

import com.arcbees.project.client.BootStrapper;
import com.arcbees.project.client.BootStrapperImpl;
import com.arcbees.project.client.application.ApplicationModule;
import com.arcbees.project.client.place.DefaultPlace;
import com.arcbees.project.client.place.NameTokens;
import com.arcbees.project.client.place.PlaceManager;
import com.arcbees.project.shared.dto.CurrentUserDto;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule(PlaceManager.class));
        install(new ApplicationModule());

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);
        bind(CurrentUserDto.class).asEagerSingleton();
        bind(BootStrapper.class).to(BootStrapperImpl.class).in(Singleton.class);
    }
}
