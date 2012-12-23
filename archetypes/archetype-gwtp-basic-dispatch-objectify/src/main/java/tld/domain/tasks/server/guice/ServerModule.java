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

package tld.domain.tasks.server.guice;

import tld.domain.tasks.server.authentication.AuthenticationModule;
import tld.domain.tasks.server.dispatch.DispatchHandlersModule;

import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        install(new DispatchHandlersModule());
        install(new AuthenticationModule());
    }
}
