package com.arcbees.project.client.dispatch;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Global RPC onFailure System
 */
public abstract class AsyncCallbackImpl<T> implements AsyncCallback<T> {
    @Override
    public void onFailure(Throwable caught) {
        Window.alert("Communication to the server has failed.");
    }
}
