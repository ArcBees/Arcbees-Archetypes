package com.arcbees.project.server.dispatch.validators;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.gwtplatform.dispatch.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.Result;

public class AdminActionValidator implements ActionValidator {
    @Override
    public boolean isValid(Action<? extends Result> action) {
        UserService user = UserServiceFactory.getUserService();
        
        return user.isUserAdmin();
    }
}