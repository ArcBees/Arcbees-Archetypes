#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.dao;

import com.arcbees.project.shared.domain.Task;

public class TaskDao extends BaseDao<Task> {
    protected TaskDao() {
        super(Task.class);
    }

    public Integer findTotalCount() {
        return ofy().query(Task.class).count();
    }
}
