package tld.domain.tasks.client.application.widget.login;

import tld.domain.tasks.shared.dto.CurrentUserDto;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView> implements
        LoginUiHandlers {
    public interface MyView extends View, HasUiHandlers<LoginUiHandlers> {
        void displayLoggedIn(String string);

        void displayLoggedOut(String string);

        void displayNickname(String nickname);
    }
    
    private final CurrentUserDto currentUserDto;

    @Inject
    public LoginPresenter(final EventBus eventBus, final MyView view, final CurrentUserDto currentUserDto) {
        super(eventBus, view);
        this.currentUserDto = currentUserDto;

        getView().setUiHandlers(this);
    }
    
    @Override
    protected void onReveal() {
        super.onReveal();
        
        displayLogin();
    }

    private void displayLogin() {
        if (currentUserDto.isLoggedIn()) {
            getView().displayNickname(currentUserDto.getNickname());
            getView().displayLoggedIn(currentUserDto.getLogoutUrl());
        } else {
            getView().displayNickname("");
            getView().displayLoggedOut(currentUserDto.getLoginUrl());
        }
    }
}
