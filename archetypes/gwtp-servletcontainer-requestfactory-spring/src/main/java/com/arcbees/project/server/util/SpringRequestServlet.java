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

package com.arcbees.project.server.util;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringRequestServlet extends RequestFactoryServlet {
    static class LoquaciousExceptionHandler implements ExceptionHandler {
        private static final Logger LOG = LoggerFactory.getLogger(LoquaciousExceptionHandler.class);

        @Override
        public ServerFailure createServerFailure(Throwable throwable) {
            LOG.error("Server error", throwable);
            return new ServerFailure(throwable.getMessage(), throwable.getClass().getName(), null, true);
        }
    }

    public SpringRequestServlet() {
        super(new LoquaciousExceptionHandler());
    }
}
