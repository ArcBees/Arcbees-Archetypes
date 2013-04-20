#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
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
    public CurrentUserDtoProvider(UserDao userDao) {
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
