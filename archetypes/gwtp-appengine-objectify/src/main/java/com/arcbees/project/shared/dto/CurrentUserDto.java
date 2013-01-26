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

package com.arcbees.project.shared.dto;

import com.arcbees.project.shared.domain.User;

public class CurrentUserDto implements Dto {
    private Boolean isAdmin;
    private Boolean isLoggedIn;
    private User user;
    private String logoutUrl;
    private String loginUrl;
    private String nickname;

    public CurrentUserDto() {
        isAdmin = false;
        isLoggedIn = false;
        user = new User();
        loginUrl = "";
        logoutUrl = "";
    }

    public CurrentUserDto(Boolean isLoggedIn, User user) {
        this.isLoggedIn = isLoggedIn;
        this.user = user;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }
    
    public Boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    public User getUser() {
        return user;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }
    
    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
    
    public String getLoginUrl() {
        return loginUrl;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void copyFrom(CurrentUserDto currentUser) {
        isAdmin = currentUser.isAdmin;
        isLoggedIn = currentUser.isLoggedIn;
        user = currentUser.user;
        logoutUrl = currentUser.logoutUrl;
        loginUrl = currentUser.loginUrl;
        nickname = currentUser.nickname;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
