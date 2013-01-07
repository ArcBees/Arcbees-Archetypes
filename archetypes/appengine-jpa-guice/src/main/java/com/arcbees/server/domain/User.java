package com.arcbees.server.domain;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    private String googleId;

    public User() {
        googleId = "";
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}