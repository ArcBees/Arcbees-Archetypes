/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.server;

import com.arcbees.myproject.shared.SendTextToServerAction;
import com.arcbees.myproject.shared.SendTextToServerResult;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.google.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.arcbees.myproject.shared.FieldVerifier;

public class SendTextToServerHandler implements
    ActionHandler<SendTextToServerAction, SendTextToServerResult> {

  private final ServletContext servletContext;

  private final Provider<HttpServletRequest> requestProvider;

  @Inject
  public SendTextToServerHandler(final ServletContext servletContext, final Provider<HttpServletRequest> requestProvider) {

    this.servletContext = servletContext;
    this.requestProvider = requestProvider;
  }

  @Override
  public SendTextToServerResult execute(SendTextToServerAction action,
      ExecutionContext context) throws ActionException {
    String input = action.getTextToServer();

    // Verify that the input is valid.
    if (!FieldVerifier.isValidName(input)) {
      // If the input is not valid, throw an IllegalArgumentException back to
      // the client.
      throw new ActionException("Name must be at least 4 characters long");
    }

    String serverInfo = servletContext.getServerInfo();
    String userAgent = requestProvider.get().getHeader("User-Agent");
    return new SendTextToServerResult("Hello, " + input
        + "!<br><br>I am running " + serverInfo
        + ".<br><br>It looks like you are using:<br>" + userAgent);
  }

  @Override
  public void undo(SendTextToServerAction action, SendTextToServerResult result,
      ExecutionContext context) throws ActionException {
  }

  @Override
  public Class<SendTextToServerAction> getActionType() {
    return SendTextToServerAction.class;
  }
}
