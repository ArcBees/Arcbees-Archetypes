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

import javax.inject.Inject;

import com.arcbees.project.client.application.ApplicationPresenter;
import com.arcbees.project.client.dispatch.AsyncCallbackImpl;
import com.arcbees.project.client.place.NameTokens;
import com.arcbees.project.shared.dispatch.FetchTaskAction;
import com.arcbees.project.shared.dispatch.FetchTaskResult;
import com.arcbees.project.shared.domain.Task;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    private DispatchAsync dispatcher;

    @Inject
    HomePagePresenter(EventBus eventBus,
                      MyView view,
                      MyProxy proxy,
                      DispatchAsync dispatcher) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

        this.dispatcher = dispatcher;
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        fetchTask();
    }

    private void fetchTask() {
        FetchTaskAction action = new FetchTaskAction();
        action.setTaskId(1l);

        dispatcher.execute(action, new AsyncCallbackImpl<FetchTaskResult>() {
            @Override
            public void onSuccess(FetchTaskResult result) {
                displayTask(result.getTask());
            }
        });
    }

    private void displayTask(Task task) {
        System.out.println("task=" + task);
    }
}
