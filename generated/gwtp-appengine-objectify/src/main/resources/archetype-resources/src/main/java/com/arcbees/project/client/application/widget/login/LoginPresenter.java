#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
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

package com.arcbees.project.client.application.widget.login;

import com.arcbees.project.shared.dto.CurrentUserDto;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView> implements LoginUiHandlers {
    public interface MyView extends View, HasUiHandlers<LoginUiHandlers> {
        void displayLoggedIn(String string);

        void displayLoggedOut(String string);

        void displayNickname(String nickname);
    }

    private final CurrentUserDto currentUserDto;

    @Inject
    public LoginPresenter(final EventBus eventBus, final MyView view, final CurrentUserDto currentUserDto) {
        super(eventBus, view);

        this.currentUserDto = currentUserDto;

        getView().setUiHandlers(this);
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        displayLogin();
    }

    private void displayLogin() {
        if (currentUserDto.isLoggedIn()) {
            String url = replaceReturnPath(currentUserDto.getLogoutUrl());
            getView().displayNickname(currentUserDto.getNickname());
            getView().displayLoggedIn(url);
        } else {
            String url = replaceReturnPath(currentUserDto.getLoginUrl());
            getView().displayNickname("");
            getView().displayLoggedOut(url);
        }
    }

    private String replaceReturnPath(String url) {
        String path = Window.Location.getPath();
        if (path != null && path.length() > 0) {
            path = path.replace("/", "%2F");
            url = url.replace("%2F", path);
        }

        String queryString = Window.Location.getQueryString();
        String token = History.getToken();
        if (queryString != null) {
            url += URL.encode(queryString);
        }
        
        if (token != null && token.length() > 0) {
            url += "%23" + path + URL.encode(token);
        }

        return url;
    }
}
