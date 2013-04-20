#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.guice;

import com.arcbees.project.server.authentication.AuthenticationModule;
import com.arcbees.project.server.dispatch.DispatchHandlersModule;
import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        install(new DispatchHandlersModule());
        install(new AuthenticationModule());
    }
}
