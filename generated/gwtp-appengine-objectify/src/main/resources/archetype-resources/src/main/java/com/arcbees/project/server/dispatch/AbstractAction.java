#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.arcbees.project.server.dispatch;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.ActionException;
import com.gwtplatform.dispatch.shared.Result;

/**
 * Simple abstract super-class for {@link com.gwtplatform.dispatch.server.actionhandler.ActionHandler} implementations
 * that forces the {@link com.gwtplatform.dispatch.shared.Action} class to be passed in as a constructor to the handler.
 * 
 * @param <A> The {@link com.gwtplatform.dispatch.shared.Action} type.
 * @param <R> The {@link com.gwtplatform.dispatch.shared.Result} type.
 */
public abstract class AbstractAction<A extends Action<R>, R extends Result> implements ActionHandler<A, R> {
    private final Class<A> actionType;

    public AbstractAction(Class<A> actionType) {
        this.actionType = actionType;
    }

    public Class<A> getActionType() {
        return actionType;
    }

    @Override
    public void undo(A action, R result, ExecutionContext context) throws ActionException {
    }
}
