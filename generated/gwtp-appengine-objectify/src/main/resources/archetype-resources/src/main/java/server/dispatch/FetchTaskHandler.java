#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dispatch;

import ${package}.server.dao.TaskDao;
import ${package}.shared.dispatch.FetchTaskAction;
import ${package}.shared.dispatch.FetchTaskResult;
import ${package}.shared.domain.Task;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class FetchTaskHandler extends AbstractAction<FetchTaskAction, FetchTaskResult> {
    private final TaskDao taskDao;

    @Inject
    FetchTaskHandler(TaskDao taskDao) {
        super(FetchTaskAction.class);

        this.taskDao = taskDao;
    }

    @Override
    public FetchTaskResult execute(FetchTaskAction action, ExecutionContext context) throws ActionException {
        Task task = taskDao.get(action.getTaskId());

        return new FetchTaskResult(task);
    }
}
