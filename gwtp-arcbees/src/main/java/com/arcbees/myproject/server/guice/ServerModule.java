/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.server.guice;

import com.arcbees.myproject.shared.SendTextToServerAction;
import com.gwtplatform.dispatch.server.guice.HandlerModule;
import com.arcbees.myproject.server.SendTextToServerHandler;

public class ServerModule extends HandlerModule {

  @Override
  protected void configureHandlers() {
    bindHandler(SendTextToServerAction.class, SendTextToServerHandler.class);
  }

}
