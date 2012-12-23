package tld.domain.tasks.client.application.widget.header;

import com.arcbees.core.client.mvp.uihandlers.SetterUiHandlersStrategy;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.google.inject.TypeLiteral;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HeaderModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenterWidget(HeaderPresenter.class, HeaderPresenter.MyView.class, HeaderView.class);

        bind(new TypeLiteral<UiHandlersStrategy<HeaderUiHandlers>>() {
        }).to(new TypeLiteral<SetterUiHandlersStrategy<HeaderUiHandlers>>() {
        });
        bind(HeaderUiHandlers.class).to(HeaderPresenter.class);
    }
}
