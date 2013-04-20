#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.shared.dispatch;

import com.arcbees.project.shared.domain.Task;
import com.gwtplatform.dispatch.shared.Result;

public class FetchTaskResult implements Result {
    private Task task;

    public FetchTaskResult() {
    }

    public FetchTaskResult(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
