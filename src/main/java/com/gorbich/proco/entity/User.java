package com.gorbich.proco.entity;

/**
 * User Bean.
 * Class represents users in database.
 */
public class User {
    private int userId;
    private String userName;
    private String userPass;

    /**
     * Empty Constructor
     */
    public User() {
    }

    /**
     * Constructor to load properties
     * @param userId
     * @param userPass
     * @param userName
     */
    public User(int userId, String userPass, String userName) {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
    }

    /**
     * Getter for User ID
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter for User ID
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Getter for User Name
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for User Name
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for User Password
     * @return userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * Setter for User Password
     * @param userPass
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
