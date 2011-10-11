/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.client.main;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ResponseView extends ViewImpl implements ResponsePresenter.MyView {

  private static String html = "<h1>Remote Procedure Call</h1>\n"
      + "<table align=\"center\">\n" + "  <tr>\n"
      + "    <td style=\"font-weight:bold;\">Sending name to server:</td>\n"
      + "  </tr>\n" + "  <tr>\n" + "    <td id=\"textToServerContainer\"></td>\n"
      + "  </tr>\n" + "  <tr>\n"
      + "    <td style=\"font-weight:bold;\">Server replies:</td>\n"
      + "  </tr>\n" + "  <tr>\n"
      + "    <td id=\"serverResponseContainer\"></td>\n" + "  </tr>\n"
      + "  <tr>\n" + "    <td id=\"closeButton\"></td>\n" + "  </tr>\n"
      + "</table>\n";
  private final HTMLPanel panel = new HTMLPanel(html);
  private final Label textToServerLabel;
  private final HTML serverResponseLabel;
  private final Button closeButton;

  @Inject
  public ResponseView() {

    closeButton = new Button("Close");
    // We can set the id of a widget by accessing its Element
    closeButton.getElement().setId("closeButton");
    textToServerLabel = new Label();
    serverResponseLabel = new HTML();

    // Add the nameField and sendButton to the RootPanel
    // Use RootPanel.get() to get the entire body element
    panel.add(closeButton, "closeButton");
    panel.add(textToServerLabel, "textToServerContainer");
    panel.add(serverResponseLabel, "serverResponseContainer");
  }

  @Override
  public Widget asWidget() {
    return panel;
  }

  @Override
  public HasClickHandlers getCloseClickHandlers() {
    return closeButton;
  }

  @Override
  public void setServerResponse(String serverResponse) {
    serverResponseLabel.setHTML(serverResponse);
  }

  @Override
  public void setTextToServer(String textToServer) {
    textToServerLabel.setText(textToServer);
  }
}
