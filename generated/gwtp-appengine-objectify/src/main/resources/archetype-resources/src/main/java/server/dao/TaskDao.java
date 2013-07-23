#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dao;

import ${package}.shared.domain.Task;

public class TaskDao extends BaseDao<Task> {
    protected TaskDao() {
        super(Task.class);
    }

    public Integer findTotalCount() {
        return ofy().query(Task.class).count();
    }
}
