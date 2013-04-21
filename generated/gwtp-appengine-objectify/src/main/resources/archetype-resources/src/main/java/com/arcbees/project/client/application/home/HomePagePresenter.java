#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.client.application.home;

import com.arcbees.project.client.application.ApplicationPresenter;
import com.arcbees.project.client.dispatch.AsyncCallbackImpl;
import com.arcbees.project.client.place.NameTokens;
import com.arcbees.project.shared.dispatch.FetchTaskAction;
import com.arcbees.project.shared.dispatch.FetchTaskResult;
import com.arcbees.project.shared.domain.Task;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
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
    public HomePagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
            final DispatchAsync dispatcher) {
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);

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
