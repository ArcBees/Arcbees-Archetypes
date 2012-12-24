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

package com.arcbees.myproject.client.application.home;

import com.arcbees.core.client.mvp.ViewWithUiHandlers;
import com.arcbees.core.client.mvp.uihandlers.UiHandlersStrategy;
import com.arcbees.myproject.client.application.home.ui.MyEntityEditor;
import com.arcbees.myproject.client.request.proxy.MyEntityProxy;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.inject.Inject;

import java.util.List;


public class HomePageView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePagePresenter.MyView {
    public interface Binder extends UiBinder<Widget, HomePageView> {
    }

    @UiField(provided = true)
    MyEntityEditor myEntityEditor;
    @UiField(provided = true)
    CellTable<MyEntityProxy> myTable;

    private final ListDataProvider<MyEntityProxy> dataProvider;

    @Inject
    public HomePageView(final Binder uiBinder, final MyEntityEditor myEntityEditor,
                        final ListDataProvider<MyEntityProxy> dataProvider,
                        final UiHandlersStrategy<HomeUiHandlers> uiHandlers) {
        super(uiHandlers);

        this.myEntityEditor = myEntityEditor;
        this.dataProvider = dataProvider;
        this.myTable = new CellTable<MyEntityProxy>();

        initWidget(uiBinder.createAndBindUi(this));
        initCellTable();
        dataProvider.addDataDisplay(myTable);
    }

    @Override
    public void editUser(MyEntityProxy myEntity) {
        myEntityEditor.edit(myEntity);
    }

    @Override
    public void setData(List<MyEntityProxy> data) {
        dataProvider.getList().clear();
        dataProvider.getList().addAll(data);
        dataProvider.refresh();
    }

    @UiHandler("submit")
    void onSubmitClicked(ClickEvent event) {
        getUiHandlers().saveEntity(myEntityEditor.get());
    }

    private void initCellTable() {
        TextColumn<MyEntityProxy> firstNameColumn = new TextColumn<MyEntityProxy>() {
            @Override
            public String getValue(MyEntityProxy object) {
                return object.getFirstName();
            }
        };
        myTable.addColumn(firstNameColumn, "First name");

        TextColumn<MyEntityProxy> lastNameColumn = new TextColumn<MyEntityProxy>() {
            @Override
            public String getValue(MyEntityProxy object) {
                return object.getLastName();
            }
        };
        myTable.addColumn(lastNameColumn, "Last name");
    }
}
