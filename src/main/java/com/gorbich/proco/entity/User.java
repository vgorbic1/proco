package com.gorbich.proco.entity;

/**
 * User Bean.
 * Class represents users in database.
 */
public class User {
    private int userId;
    private String userName;
    private byte[] userPass;
    private byte[] salt;
    private String adminPass;

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
    public User(int userId, byte[] userPass, String userName, byte[] salt) {
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
        this.salt = salt;
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
    public byte[] getUserPass() {
        return userPass;
    }

    /**
     * Setter for User Password
     * @param userPass
     */
    public void setUserPass(byte[] userPass) {
        this.userPass = userPass;
    }

    /**
     * Getter for Salt (Encryption)
     * @return salt
     */
    public byte[] getSalt() {
        return salt;
    }

    /**
     * Setter for Salt (Encryption)
     * @param salt
     */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    /**
     * Getter for Administrator password
     * @return adminPass
     */
    public String getAdminPass() {
        return adminPass;
    }

    /**
     * Setter for Administrator password
     * @param adminPass
     */
    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }
}
