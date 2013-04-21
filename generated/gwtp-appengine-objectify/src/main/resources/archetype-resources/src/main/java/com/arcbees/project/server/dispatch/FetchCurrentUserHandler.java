#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.dispatch;

import com.arcbees.project.server.authentication.CurrentUserDtoProvider;
import com.arcbees.project.shared.dispatch.FetchCurrentUserAction;
import com.arcbees.project.shared.dispatch.FetchCurrentUserResult;
import com.arcbees.project.shared.dto.CurrentUserDto;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchCurrentUserHandler extends AbstractAction<FetchCurrentUserAction, FetchCurrentUserResult> {
    private CurrentUserDtoProvider currentUserDtoProvider;

    @Inject
    public FetchCurrentUserHandler(CurrentUserDtoProvider currentUserDtoProvider) {
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
