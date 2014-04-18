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

import javax.inject.Inject;

import com.arcbees.project.server.dao.TaskDao;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountAction;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountResult;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchAdminTaskCountHandler extends AbstractAction<FetchAdminTaskCountAction, FetchAdminTaskCountResult> {
    private final TaskDao taskDao;

    @Inject
    FetchAdminTaskCountHandler(TaskDao taskDao) {
        super(FetchAdminTaskCountAction.class);

        this.taskDao = taskDao;
    }

    @Override
    public FetchAdminTaskCountResult execute(FetchAdminTaskCountAction action, ExecutionContext context)
            throws ActionException {
        Integer totalCount = taskDao.findTotalCount();

        return new FetchAdminTaskCountResult(totalCount);
    }
}
