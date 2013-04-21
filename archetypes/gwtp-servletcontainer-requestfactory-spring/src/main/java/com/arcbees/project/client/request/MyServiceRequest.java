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

package com.arcbees.project.client.request;

import com.arcbees.project.client.request.proxy.MyEntityProxy;
import com.arcbees.project.server.service.impl.MyServiceImpl;
import com.arcbees.project.server.util.SpringServiceLocator;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

import java.util.List;

@Service(value = MyServiceImpl.class, locator = SpringServiceLocator.class)
public interface MyServiceRequest extends RequestContext {
    abstract Request<Void> create(MyEntityProxy entity);

    abstract Request<Void> delete(MyEntityProxy entity);

    abstract Request<List<MyEntityProxy>> loadAll(String searchToken);
}
