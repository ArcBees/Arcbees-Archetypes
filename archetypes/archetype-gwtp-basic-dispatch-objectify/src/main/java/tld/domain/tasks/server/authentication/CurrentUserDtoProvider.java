/**
 * Copyright 2011 ArcBees Inc.  All rights reserved.
 */

package tld.domain.tasks.server.authentication;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import tld.domain.tasks.server.dao.UserDao;
import tld.domain.tasks.shared.domain.User;
import tld.domain.tasks.shared.dto.CurrentUserDto;

public class CurrentUserDtoProvider implements Provider<CurrentUserDto> {
    private final UserDao userDao;
    private final Provider<HttpSession> sessionProvider;
    private final CurrentUserDtoFactory currentUserDtoFactory;

    @Inject
    public CurrentUserDtoProvider(final UserDao userDao, final Provider<HttpSession> sessionProvider,
            final CurrentUserDtoFactory currentUserDtoFactory) {
        this.userDao = userDao;
        this.sessionProvider = sessionProvider;
        this.currentUserDtoFactory = currentUserDtoFactory;
    }

    @Override
    public CurrentUserDto get() {
        HttpSession session = sessionProvider.get();
        Long currentUserId = (Long) session.getAttribute("userId");
        User user = null;

        if (currentUserId != null) {
            user = userDao.get(currentUserId);
        }

        return currentUserDtoFactory.create(user);
    }
}
