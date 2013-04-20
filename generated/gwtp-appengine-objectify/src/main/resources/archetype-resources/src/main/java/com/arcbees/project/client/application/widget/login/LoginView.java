#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.client.application.widget.login;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LoginView extends ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {
    public interface Binder extends UiBinder<HTMLPanel, LoginView> {
    }

    @UiField
    InlineHTML nickname;
    @UiField
    Anchor link;

    @Inject
    public LoginView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void displayNickname(String nickname) {
        this.nickname.setHTML(nickname);
    }

    @Override
    public void displayLoggedIn(String logoutUrl) {
        link.setText("Log Out");
        link.setHref(logoutUrl);
    }

    @Override
    public void displayLoggedOut(String loginUrl) {
        link.setText("Log In");
        link.setHref(loginUrl);
    }
}
