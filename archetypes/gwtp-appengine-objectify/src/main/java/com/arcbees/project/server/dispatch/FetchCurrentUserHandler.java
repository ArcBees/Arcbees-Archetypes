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

package com.arcbees.project.server.dispatch;

import com.arcbees.project.server.authentication.CurrentUserDtoProvider;
import com.arcbees.project.shared.dispatch.FetchCurrentUserAction;
import com.arcbees.project.shared.dispatch.FetchCurrentUserResult;
import com.arcbees.project.shared.dto.CurrentUserDto;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchCurrentUserHandler extends AbstractAction<FetchCurrentUserAction, FetchCurrentUserResult> {
    private CurrentUserDtoProvider currentUserDtoProvider;

    @Inject
    public FetchCurrentUserHandler(CurrentUserDtoProvider currentUserDtoProvider) {
        super(FetchCurrentUserAction.class);

        this.currentUserDtoProvider = currentUserDtoProvider;
    }

    @Override
    public FetchCurrentUserResult execute(FetchCurrentUserAction action, ExecutionContext context)
            throws ActionException {
        CurrentUserDto currentUser = currentUserDtoProvider.get();

        return new FetchCurrentUserResult(currentUser);
    }
}
