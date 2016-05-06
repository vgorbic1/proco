package com.gorbich.proco.entity;

import java.io.Serializable;

/**
 * Utility class to use for primary key mapping in Hibernate.
 */
public class UserRolesPK implements Serializable {
    private String userName;
    private String userRole;

    /**
     * Getter for User Name
     * @return username
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesPK that = (UserRolesPK) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null)
            return false;
        if (userRole != null ? !userRole.equals(that.userRole) : that.userRole != null)
            return false;

        return true;
    }
}
