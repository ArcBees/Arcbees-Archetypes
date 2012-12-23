package tld.domain.tasks.server.authentication;

import tld.domain.tasks.shared.domain.User;
import tld.domain.tasks.shared.dto.CurrentUserDto;

public class CurrentUserDtoFactory {
    public CurrentUserDto create(User user) {
        CurrentUserDto currentUser = new CurrentUserDto(user != null, user);

        return currentUser;
    }
}
