package com.arcbees.project.server.dispatch;

import com.arcbees.project.server.dao.TaskDao;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountAction;
import com.arcbees.project.shared.dispatch.FetchAdminTaskCountResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchAdminTaskCountHandler extends AbstractAction<FetchAdminTaskCountAction, FetchAdminTaskCountResult> {
    private final TaskDao taskDao;

    @Inject
    public FetchAdminTaskCountHandler(final TaskDao taskDao) {
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
