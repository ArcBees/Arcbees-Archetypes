package com.arcbees.server.guice;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
      install(new JpaPersistModule("transactions-optional"));
      bind(JpaInitilization.class).asEagerSingleton();
    }
}