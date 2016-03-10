package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.User;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Vlad on 3/4/2016.
 */
public class UserDaoHibernateTest {

    @Test
    public void testGetAllUsers() throws Exception {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        List<User> users = userHibernate.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        User user = new User();
        // To make the test pass make sure ID exists in database
        user.setUserId(1);
        user.setUserName("Test Update UserName");
        user.setUserPass("Test Update UserPass");
        userHibernate.updateUser(user);
        assertEquals(1, user.getUserId());
        assertEquals("Test Update User", user.getUserName());
    }

    @Test
    public void testDeleteUser() throws Exception {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        User user = new User();
        // To have the test pass make sure ID exists in database
        user.setUserId(2);
        userHibernate.deleteUser(user);
        List<User> users = userHibernate.getAllUsers();
        for (User testUser : users){
            assertFalse(testUser.getUserId() == 2);
        }
    }

    @Test
    public void testAddUser() throws Exception {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        int insertedUserId;
        User user = new User();
        user.setUserName("TestAddUser");
        user.setUserPass("TestAddPass");
        insertedUserId = userHibernate.addUser(user);
        assertTrue(insertedUserId > 0);
    }
}