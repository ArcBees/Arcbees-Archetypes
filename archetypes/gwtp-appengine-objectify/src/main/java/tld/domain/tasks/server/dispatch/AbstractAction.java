/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package tld.domain.tasks.server.dispatch;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.ActionException;
import com.gwtplatform.dispatch.shared.Result;

/**
 * Simple abstract super-class for
 * {@link com.gwtplatform.dispatch.server.actionhandler.ActionHandler}
 * implementations that forces the
 * {@link com.gwtplatform.dispatch.shared.Action} class to be passed in as a
 * constructor to the handler.
 * 
 * @param <A>
 *            The {@link com.gwtplatform.dispatch.shared.Action} type.
 * @param <R>
 *            The {@link com.gwtplatform.dispatch.shared.Result} type.
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
