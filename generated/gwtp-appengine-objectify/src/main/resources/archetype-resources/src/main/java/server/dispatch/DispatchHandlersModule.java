#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dispatch;

import ${package}.server.dispatch.validators.AdminActionValidator;
import ${package}.shared.dispatch.FetchAdminTaskCountAction;
import ${package}.shared.dispatch.FetchCurrentUserAction;
import ${package}.shared.dispatch.FetchTaskAction;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class DispatchHandlersModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(FetchTaskAction.class, FetchTaskHandler.class);
        bindHandler(FetchCurrentUserAction.class, FetchCurrentUserHandler.class);

        // This fetch has a Validator which only lets App Admins fetch it.
        bindHandler(FetchAdminTaskCountAction.class, FetchAdminTaskCountHandler.class, AdminActionValidator.class);
    }
}
