package com.gorbich.proco.entity;

/**
 * User Bean.
 * Class represents users.
 */
public class User {
    private int userId;
    private String userName;
    private String userPass;

    public User() {
    }

    public User(int userId, String userPass, String userName) {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
