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

package com.arcbees.project.client.application.home;

import com.arcbees.project.client.application.ApplicationPresenter;
import com.arcbees.project.client.place.NameTokens;
import com.arcbees.project.client.request.MyRequestFactory;
import com.arcbees.project.client.request.MyServiceRequest;
import com.arcbees.project.client.request.proxy.MyEntityProxy;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import java.util.List;


public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy>
        implements HomeUiHandlers {
    public interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
        void editUser(MyEntityProxy myEntity);

        void setData(List<MyEntityProxy> data);
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    private final MyRequestFactory requestFactory;

    private MyServiceRequest currentContext;
    private String searchToken;

    @Inject
    public HomePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
                             final MyRequestFactory requestFactory) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);

        this.requestFactory = requestFactory;

        getView().setUiHandlers(this);
    }

    @Override
    public void saveEntity(MyEntityProxy myEntity) {
        currentContext.create(myEntity).fire(new Receiver<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                loadEntities();
                initializeContext();
            }
        });
    }

    @Override
    protected void onReveal() {
        searchToken = "";
        initializeContext();
        loadEntities();
    }

    private void initializeContext() {
        currentContext = requestFactory.myService();
        MyEntityProxy newEntity = currentContext.create(MyEntityProxy.class);
        getView().editUser(newEntity);
    }

    private void loadEntities() {
        requestFactory.myService().loadAll(searchToken).fire(new Receiver<List<MyEntityProxy>>() {
            @Override
            public void onSuccess(List<MyEntityProxy> data) {
                getView().setData(data);
            }
        });
    }
}
