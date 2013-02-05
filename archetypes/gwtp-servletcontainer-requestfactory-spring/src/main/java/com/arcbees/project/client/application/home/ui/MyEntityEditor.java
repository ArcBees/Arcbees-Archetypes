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

package com.arcbees.project.client.application.home.ui;


import com.arcbees.project.client.request.proxy.MyEntityProxy;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MyEntityEditor extends Composite implements Editor<MyEntityProxy> {
    public interface Binder extends UiBinder<Widget, MyEntityEditor> {
    }

    public interface Driver extends SimpleBeanEditorDriver<MyEntityProxy, MyEntityEditor> {
    }

    @UiField
    TextBox firstName;
    @UiField
    TextBox lastName;

    private final Driver driver;

    @Inject
    public MyEntityEditor(final Binder uiBinder, final Driver driver) {
        this.driver = driver;

        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(this);
    }

    public void edit(MyEntityProxy myEntity) {
        firstName.setFocus(true);
        driver.edit(myEntity);
    }

    public MyEntityProxy get() {
        MyEntityProxy myEntity = driver.flush();
        if (driver.hasErrors()) {
            return null;
        } else {
            return myEntity;
        }
    }
}