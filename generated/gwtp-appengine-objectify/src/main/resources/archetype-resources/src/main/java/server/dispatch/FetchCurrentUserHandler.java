#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dispatch;

import javax.inject.Inject;

import ${package}.server.authentication.CurrentUserDtoProvider;
import ${package}.shared.dispatch.FetchCurrentUserAction;
import ${package}.shared.dispatch.FetchCurrentUserResult;
import ${package}.shared.dto.CurrentUserDto;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchCurrentUserHandler extends AbstractAction<FetchCurrentUserAction, FetchCurrentUserResult> {
    private CurrentUserDtoProvider currentUserDtoProvider;

    @Inject
    FetchCurrentUserHandler(CurrentUserDtoProvider currentUserDtoProvider) {
        super(FetchCurrentUserAction.class);

        this.currentUserDtoProvider = currentUserDtoProvider;
    }

    @Override
    public FetchCurrentUserResult execute(FetchCurrentUserAction action, ExecutionContext context)
            throws ActionException {
        CurrentUserDto currentUser = currentUserDtoProvider.get();

        return new FetchCurrentUserResult(currentUser);
    }
}
