package tld.domain.tasks.shared.dto;

import tld.domain.tasks.shared.domain.User;

public class CurrentUserDto implements Dto {
    private Boolean loggedIn;
    private User user;

    public CurrentUserDto() {
        loggedIn = false;
        user = new User();
    }

    public CurrentUserDto(Boolean loggedIn, User user) {
        this.loggedIn = loggedIn;
        this.user = user;
    }

    public Boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
