package com.arcbees.project.shared.dispatch;


import com.arcbees.project.shared.dto.CurrentUserDto;
import com.gwtplatform.dispatch.shared.Result;

public class FetchCurrentUserResult implements Result {
    private CurrentUserDto currentUser;

    public FetchCurrentUserResult() {
    }
    
    public FetchCurrentUserResult(CurrentUserDto currentUser) {
        this.currentUser = currentUser;
    }

    public CurrentUserDto getCurrentUser() {
        return currentUser;
    }
}
