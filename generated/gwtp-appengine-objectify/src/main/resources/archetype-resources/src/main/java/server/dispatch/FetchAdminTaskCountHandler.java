#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dispatch;

import javax.inject.Inject;

import ${package}.server.dao.TaskDao;
import ${package}.shared.dispatch.FetchAdminTaskCountAction;
import ${package}.shared.dispatch.FetchAdminTaskCountResult;
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
