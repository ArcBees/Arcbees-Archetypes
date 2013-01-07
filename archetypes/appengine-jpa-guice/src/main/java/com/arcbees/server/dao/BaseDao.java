package com.arcbees.server.dao;

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
        List<T> list = entityManager.createQuery("select o from " + clazz.getName() + " o").getResultList();
        return list; 
    }

    public T put(T object) {
        entityManager.persist(object);
        return object;
    }

    public T get(Key key) {
        T value = entityManager.find(clazz, key);
        return value;
    }

    public T get(Long id) {
        Key key = KeyFactory.createKey(clazz.getName(), id);
        T value = entityManager.find(clazz, key);
        return value;
    }
}