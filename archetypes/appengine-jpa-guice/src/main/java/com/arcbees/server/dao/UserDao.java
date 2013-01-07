package com.arcbees.server.dao;

import javax.persistence.Query;

import com.arcbees.server.domain.User;

public class UserDao extends BaseDao<User> {
    public UserDao() {
      super(User.class);
    }

    public User findByGoogleId(String googleId) {
      Query query = entityManager.createQuery("select o from " + User.class.getName() + " o where o.googleId = :googleId");
      query.setParameter("googleId", googleId);
      User user = (User) query.getSingleResult();
      entityManager.clear();
      return user;
    }
  }
