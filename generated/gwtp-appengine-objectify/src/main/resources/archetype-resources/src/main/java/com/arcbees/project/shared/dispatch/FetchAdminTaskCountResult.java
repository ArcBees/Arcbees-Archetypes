package com.arcbees.project.shared.dispatch;

import com.gwtplatform.dispatch.shared.Result;

public class FetchAdminTaskCountResult implements Result {
    private Integer totalTasks;

    public FetchAdminTaskCountResult() {
    }

    public FetchAdminTaskCountResult(Integer totalTasks) {
        this.totalTasks = totalTasks;
    }
    
    public Integer getTotalTasksCount() {
        return totalTasks;
    }
}
