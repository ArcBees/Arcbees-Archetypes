#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.widget.login;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LoginView extends ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {
    public interface Binder extends UiBinder<HTMLPanel, LoginView> {
    }

    @UiField
    InlineHTML nickname;
    @UiField
    Anchor link;

    @Inject
    LoginView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void displayNickname(String nickname) {
        this.nickname.setHTML(nickname);
    }

    @Override
    public void displayLogInLink(String loginUrl) {
        link.setText("Log In");
        link.setHref(loginUrl);
    }

    @Override
    public void displayLogOutLink(String logoutUrl) {
        link.setText("Log Out");
        link.setHref(logoutUrl);
    }
}
