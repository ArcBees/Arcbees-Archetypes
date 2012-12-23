package tld.domain.tasks.client.application.login;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView> implements
        LoginUiHandlers {
    public interface MyView extends View, HasUiHandlers<LoginUiHandlers> {
    }
    
    public static final Object TYPE_Onnitz = new Object();

    private final DispatchAsync dispatcher;

    @Inject
    public LoginPresenter(final EventBus eventBus, final MyView view, final DispatchAsync dispatcher) {
        super(eventBus, view);

        this.dispatcher = dispatcher;

        getView().setUiHandlers(this);
    }
}
