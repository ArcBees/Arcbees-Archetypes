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

package com.arcbees.project.server.authentication;

import javax.inject.Inject;
import javax.inject.Provider;

import com.arcbees.project.server.dao.UserDao;
import com.arcbees.project.shared.domain.User;
import com.arcbees.project.shared.dto.CurrentUserDto;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class CurrentUserDtoProvider implements Provider<CurrentUserDto> {
    private final UserService userService = UserServiceFactory.getUserService();
    private final UserDao userDao;

    @Inject
    public CurrentUserDtoProvider(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CurrentUserDto get() {
        return getCurrentUserDto();
    }

    private CurrentUserDto getCurrentUserDto() {
        Boolean isLoggedIn = userService.isUserLoggedIn();

        CurrentUserDto currentUser = new CurrentUserDto(isLoggedIn, getUser());
        currentUser.setLogoutUrl(userService.createLogoutURL("/"));
        currentUser.setLoginUrl(userService.createLoginURL("/"));
        
        if (isLoggedIn) {
            currentUser.setIsAdmin(userService.isUserAdmin());
            currentUser.setNickname(userService.getCurrentUser().getNickname());
        }

        return currentUser;
    }

    private User getUser() {
        Boolean isLoggedIn = userService.isUserLoggedIn();

        User user = new User();
        if (isLoggedIn) {
            String googleId = userService.getCurrentUser().getUserId();

            user = userDao.findByGoogleId(googleId);
            if (user == null) {
                user = createUser(googleId);
            }
        }
        return user;
    }

    private User createUser(String googleId) {
        User user = new User();
        user.setGoogleId(googleId);
        return userDao.put(user);
    }
}
