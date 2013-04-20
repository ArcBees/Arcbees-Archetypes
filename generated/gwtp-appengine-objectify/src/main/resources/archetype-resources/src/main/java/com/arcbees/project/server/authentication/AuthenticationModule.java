#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.authentication;

import javax.inject.Singleton;

import com.arcbees.project.shared.dto.CurrentUserDto;
import com.google.inject.AbstractModule;
import com.google.inject.servlet.RequestScoped;

public class AuthenticationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CurrentUserDtoProvider.class).in(Singleton.class);
        bind(CurrentUserDto.class).toProvider(CurrentUserDtoProvider.class).in(RequestScoped.class);
    }
}
