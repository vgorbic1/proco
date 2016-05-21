package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Tests for Users
 */
public class UserDaoHibernateTest extends TestCase {
    UserDaoHibernate dao;

    @Before
    public void setUp() throws Exception {
        dao = new UserDaoHibernate();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> result = dao.getAllUsers();
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetUserByUserName() throws Exception {
        String userName = "testuser"; // testuser should be in the database
        User user = dao.getUserByUserName(userName);
        assertTrue(user.getUserName().equals("testuser"));
    }

    @Test
    public void testGetUserByUserId() throws Exception {
        int userId = 9; // testuser should have id equals to 9 in the database
        User user = dao.getUserByUserId(userId);
        assertTrue(user.getUserName().equals("testuser"));
    }

    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setUserName("newTestUser");
        //user.setUserPass("newTestPass");
        assertTrue(dao.register(user));
    }

    @Test
    public void testIsUserExist() throws Exception {
        User user = new User();
        user.setUserName("newTestUser");
        //user.setUserPass("newTestPass");
        assertTrue(dao.isUserExist(user));
    }

    @Test
    public void testAuthenticate() throws Exception {
        String userName = "newTestUser";
        String userPass = "newTestPass";
        assertTrue(dao.authenticate(userName, userPass));
    }

}