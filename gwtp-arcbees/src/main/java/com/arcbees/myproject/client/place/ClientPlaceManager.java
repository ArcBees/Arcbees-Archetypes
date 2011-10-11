/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */
package com.arcbees.myproject.client.place;

import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class ClientPlaceManager extends PlaceManagerImpl {

  private final PlaceRequest defaultPlaceRequest;

  @Inject
  public ClientPlaceManager(final EventBus eventBus,
      final TokenFormatter tokenFormatter,
      @DefaultPlace final String defaultPlaceNameToken) {
    super(eventBus, tokenFormatter);
    this.defaultPlaceRequest = new PlaceRequest(defaultPlaceNameToken);
  }

  @Override
  public void revealDefaultPlace() {
    revealPlace(defaultPlaceRequest, false);
  }
}
