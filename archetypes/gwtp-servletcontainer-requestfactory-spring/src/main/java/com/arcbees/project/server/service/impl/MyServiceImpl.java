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

package com.arcbees.project.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arcbees.project.server.business.MyEntity;
import com.arcbees.project.server.repos.MyEntityRepo;
import com.arcbees.project.server.service.MyService;

import java.util.List;

@Service("myService")
@Transactional
public class MyServiceImpl implements MyService {
    @Autowired
    private MyEntityRepo myEntityRepo;

    @Override
    public void create(MyEntity entity) {
        myEntityRepo.save(entity);
    }

    @Override
    public void delete(MyEntity entity) {
        myEntityRepo.delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MyEntity> loadAll(String searchToken) {
        String token = searchToken + "%";
        return myEntityRepo.findByFirstNameLikeOrLastNameLike(token, token);
    }
}
