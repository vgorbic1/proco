package com.gorbich.proco.entity;

/**
 * User Roles bean.
 * Class represents user roles in database.
 */
public class UserRoles {
    private String userName;
    private String userRole;

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
     * Getter for User Role
     * @return userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Setter for User Role
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
