#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dispatch.validators;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.gwtplatform.dispatch.rpc.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.Result;

public class AdminActionValidator implements ActionValidator {
    @Override
    public boolean isValid(Action<? extends Result> action) {
        UserService user = UserServiceFactory.getUserService();

        return user.isUserAdmin();
    }
}
