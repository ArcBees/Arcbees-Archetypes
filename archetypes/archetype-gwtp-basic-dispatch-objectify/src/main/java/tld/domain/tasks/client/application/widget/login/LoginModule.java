package tld.domain.tasks.client.application.widget.login;

import com.arcbees.core.client.mvp.uihandlers.SetterUiHandlersStrategy;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.google.inject.TypeLiteral;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LoginModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenterWidget(LoginPresenter.class, LoginPresenter.MyView.class, LoginView.class);

        bind(new TypeLiteral<UiHandlersStrategy<LoginUiHandlers>>() {
        }).to(new TypeLiteral<SetterUiHandlersStrategy<LoginUiHandlers>>() {
        });
        bind(LoginUiHandlers.class).to(LoginPresenter.class);
    }
}
