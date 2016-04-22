package com.gorbich.proco.entity;

import java.io.Serializable;

/**
 * Created by Vlad on 3/4/2016.
 */
public class UserRolesPK implements Serializable {
    private String userName;
    private String userRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

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
