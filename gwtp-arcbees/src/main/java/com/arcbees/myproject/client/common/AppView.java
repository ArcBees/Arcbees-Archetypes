/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */

package com.arcbees.myproject.client.common;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

public class AppView extends ViewImpl implements AppPresenter.MyView {
  public interface Binder extends UiBinder<Widget, AppView> {
  }

  private final Widget widget;

  @UiField
  HTMLPanel main;

  @Inject
  public AppView(final Binder uiBinder) {
    this.widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }

  @Override
  public void setInSlot(Object slot, Widget content) {
    if (slot == AppPresenter.TYPE_SetMainContent) {
      main.clear();
      main.add(content);
    } else {
      super.setInSlot(slot, content);
    }
  }
}