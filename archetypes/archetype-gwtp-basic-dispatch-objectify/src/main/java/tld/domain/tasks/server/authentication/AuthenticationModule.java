package tld.domain.tasks.server.authentication;

import javax.inject.Singleton;

import tld.domain.tasks.shared.dto.CurrentUserDto;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.RequestScoped;

public class AuthenticationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CurrentUserDtoProvider.class).in(Singleton.class);
        bind(CurrentUserDto.class).toProvider(CurrentUserDtoProvider.class).in(RequestScoped.class);
    }
}
