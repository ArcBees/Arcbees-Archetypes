package com.arcbees.server.guice;

import com.arcbees.server.servlets.HomeServlet;
import com.google.inject.servlet.ServletModule;

public class ServerServletModule extends ServletModule {
    @Override
    public void configureServlets() {
        serve("/*").with(HomeServlet.class);
    }
}