package tld.domain.tasks.client.application.login;

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;

public class LoginView extends ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {
    public interface Binder extends UiBinder<HTMLPanel, LoginView> {
    }

    @Inject
    public LoginView(final Binder binder, final UiHandlersStrategy<LoginUiHandlers> myUiHandlersUiHandlersStrategy) {
        super(myUiHandlersUiHandlersStrategy);

        initWidget(binder.createAndBindUi(this));
    }
}
