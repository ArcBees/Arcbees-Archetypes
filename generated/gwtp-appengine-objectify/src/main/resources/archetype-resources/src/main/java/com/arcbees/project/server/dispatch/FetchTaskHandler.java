package com.arcbees.project.server.dispatch;


import com.arcbees.project.server.dao.TaskDao;
import com.arcbees.project.shared.dispatch.FetchTaskAction;
import com.arcbees.project.shared.dispatch.FetchTaskResult;
import com.arcbees.project.shared.domain.Task;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchTaskHandler extends AbstractAction<FetchTaskAction, FetchTaskResult> {
    private final TaskDao taskDao;

    @Inject
    public FetchTaskHandler(final TaskDao taskDao) {
        super(FetchTaskAction.class);

        this.taskDao = taskDao;
    }

    @Override
    public FetchTaskResult execute(FetchTaskAction action, ExecutionContext context) throws ActionException {
        Task task = taskDao.get(action.getTaskId());

        return new FetchTaskResult(task);
    }
}
