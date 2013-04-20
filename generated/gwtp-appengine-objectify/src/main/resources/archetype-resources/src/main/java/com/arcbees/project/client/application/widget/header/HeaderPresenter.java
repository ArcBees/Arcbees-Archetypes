package com.arcbees.project.client.application.widget.header;


import com.arcbees.project.client.application.widget.login.LoginPresenter;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView> implements
        HeaderUiHandlers {
    public interface MyView extends View, HasUiHandlers<HeaderUiHandlers> {
    }
    
    public static final Object TYPE_LoginPresenter = new Object();
    
    private final LoginPresenter loginPresenter;
    
    @Inject
    public HeaderPresenter(final EventBus eventBus, final MyView view, final LoginPresenter loginPresenter) {
        super(eventBus, view);
        
        this.loginPresenter = loginPresenter;

        getView().setUiHandlers(this);
    }
    
    @Override
    protected void onBind() {
        super.onBind();
        
        setInSlot(TYPE_LoginPresenter, loginPresenter);
    }

    @Override
    public void onTestClick() {
        Window.alert("The Presenter says Hi test");
    }
}
