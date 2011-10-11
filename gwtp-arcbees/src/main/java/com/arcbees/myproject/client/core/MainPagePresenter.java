/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.client.core;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.arcbees.myproject.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.arcbees.myproject.shared.FieldVerifier;

public class MainPagePresenter extends
    Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> {

  public interface MyView extends View {

    HasValue<String> getNameValue();

    HasClickHandlers getSendClickHandlers();

    void resetAndFocus();

    void setError(String errorText);
  }

  @ProxyStandard
  @NameToken(NameTokens.main)
  public interface MyProxy extends ProxyPlace<MainPagePresenter> {
  }

  private final PlaceManager placeManager;

  @Inject
  public MainPagePresenter(final EventBus eventBus, final MyView view,
      final MyProxy proxy, final PlaceManager placeManager) {
    super(eventBus, view, proxy);

    this.placeManager = placeManager;
  }

  @Override
  protected void revealInParent() {
    RevealRootContentEvent.fire(this, this);
  }

  @Override
  protected void onBind() {
    super.onBind();
    registerHandler(getView().getSendClickHandlers().addClickHandler(
        new ClickHandler() {
          @Override
          public void onClick(ClickEvent event) {
            sendNameToServer();
          }
        }));
  }

  @Override
  protected void onReset() {
    super.onReset();
    getView().resetAndFocus();
  }

  /**
   * Send the name from the nameField to the server and wait for a response.
   */
  private void sendNameToServer() {
    // First, we validate the input.
    getView().setError("");
    String textToServer = getView().getNameValue().getValue();
    if (!FieldVerifier.isValidName(textToServer)) {
      getView().setError("Please enter at least four characters");
      return;
    }

    // Then, we transmit it to the ResponsePresenter, which will do the server call
    placeManager.revealPlace(new PlaceRequest(NameTokens.response).with(
        ResponsePresenter.textToServerParam, textToServer));
  }
}
