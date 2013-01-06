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

package com.arcbees.project.server.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public abstract class BaseDao<T> {
    private final Class<T> clazz;

    @Inject
    protected EntityManager entityManager;

    protected BaseDao(final Class<T> clazz) {
      this.clazz = clazz;
    }

    public List<T> getAll() {
      return entityManager.createQuery("select o from " + clazz.getName() + " o").getResultList();
    }

    public T put(T object) {
      entityManager.persist(object);
      return object;
    }

    public T get(Key key) {
      return entityManager.find(clazz, key);
    }

    public T get(Long id) {
      Key key = KeyFactory.createKey(clazz.getName(), id);
      return entityManager.find(clazz, key);
    }
  }