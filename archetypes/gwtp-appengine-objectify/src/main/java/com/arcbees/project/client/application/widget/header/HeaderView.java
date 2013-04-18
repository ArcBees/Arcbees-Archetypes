/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.project.client.application.widget.header;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HeaderView extends ViewWithUiHandlers<HeaderUiHandlers> implements HeaderPresenter.MyView {
    public interface Binder extends UiBinder<HTMLPanel, HeaderView> {
    }
    
    @UiField
    SimplePanel login;

    @Inject
    public HeaderView(final Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
    
    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == HeaderPresenter.TYPE_LoginPresenter) {
            login.setWidget(content);
        }
    }
    
    @UiHandler("test")
    public void onTestClick(ClickEvent event) {
        getUiHandlers().onTestClick();
    }
}
