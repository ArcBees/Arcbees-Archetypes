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

package com.arcbees.project.client.application.admin;

import javax.inject.Inject;

import com.arcbees.project.client.application.ApplicationPresenter;
import com.arcbees.project.client.dispatch.AsyncCallbackImpl;
import com.arcbees.project.client.place.NameTokens;
import com.arcbees.project.client.security.LoggedInGatekeeper;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountAction;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountResult;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class AdminPresenter extends Presenter<AdminPresenter.MyView, AdminPresenter.MyProxy> {
    public interface MyView extends View {
        void displayTaskCount(Integer totalTasks);
    }

    /**
     * The logged in Gatekeeper prevents folks that are not logged in from seeing this presenter.
     */
    @ProxyStandard
    @NameToken(NameTokens.admin)
    @UseGatekeeper(LoggedInGatekeeper.class)
    public interface MyProxy extends ProxyPlace<AdminPresenter> {
    }

    private DispatchAsync dispatcher;

    @Inject
    public AdminPresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        fetchTaskCount();
    }

    private void fetchTaskCount() {
        FetchAdminTaskCountAction action = new FetchAdminTaskCountAction();

        dispatcher.execute(action, new AsyncCallbackImpl<FetchAdminTaskCountResult>() {
            @Override
            public void onSuccess(FetchAdminTaskCountResult result) {
                displayTaskCount(result.getTotalTasksCount());
            }

            @Override
            public void onFailure(Throwable caught) {
                if (caught.getMessage().contains("not logged in")) {
                    Window.alert("Please login.");
                } else if (caught.getMessage().contains("couldn't allow access to action")) {
                    Window.alert("Please login as an Application Admin.");
                } else {
                    super.onFailure(caught);
                }
            }
        });
    }

    private void displayTaskCount(Integer totalTasks) {
        getView().displayTaskCount(totalTasks);
    }
}
