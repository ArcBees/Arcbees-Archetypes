#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.shared.dispatch;

import com.gwtplatform.dispatch.shared.UnsecuredActionImpl;

public class FetchTaskAction extends UnsecuredActionImpl<FetchTaskResult> {
    private Long taskId;

    public FetchTaskAction() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
