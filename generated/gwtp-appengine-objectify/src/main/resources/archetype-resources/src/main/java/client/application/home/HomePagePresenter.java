#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.home;

import ${package}.client.application.ApplicationPresenter;
import ${package}.client.dispatch.AsyncCallbackImpl;
import ${package}.client.place.NameTokens;
import ${package}.shared.dispatch.FetchTaskAction;
import ${package}.shared.dispatch.FetchTaskResult;
import ${package}.shared.domain.Task;
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
