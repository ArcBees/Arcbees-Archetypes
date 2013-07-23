#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.admin;

import ${package}.client.application.ApplicationPresenter;
import ${package}.client.dispatch.AsyncCallbackImpl;
import ${package}.client.place.NameTokens;
import ${package}.client.security.LoggedInGatekeeper;
import ${package}.shared.dispatch.FetchAdminTaskCountAction;
import ${package}.shared.dispatch.FetchAdminTaskCountResult;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
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
        super(eventBus, view, proxy, ApplicationPresenter.TYPE_SetMainContent);

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
