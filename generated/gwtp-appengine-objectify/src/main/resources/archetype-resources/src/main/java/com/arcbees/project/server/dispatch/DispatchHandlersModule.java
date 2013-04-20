#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.dispatch;

import com.arcbees.project.server.dispatch.validators.AdminActionValidator;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountAction;
import com.arcbees.project.shared.dispatch.FetchCurrentUserAction;
import com.arcbees.project.shared.dispatch.FetchTaskAction;
import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class DispatchHandlersModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(FetchTaskAction.class, FetchTaskHandler.class);
        bindHandler(FetchCurrentUserAction.class, FetchCurrentUserHandler.class);

        // This fetch has a Validator which only lets App Admins fetch it.
        bindHandler(FetchAdminTaskCountAction.class, FetchAdminTaskCountHandler.class, AdminActionValidator.class);
    }
}
