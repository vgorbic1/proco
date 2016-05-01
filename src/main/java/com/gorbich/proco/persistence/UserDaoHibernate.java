package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Hibernate to map User entity.
 */
public class UserDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The method authenticates the user by username and password.
     * @param userName
     * @param userPass
     * @return true or false
     */
    public boolean authenticate(String userName, String userPass) {
        User user = getUserByUserName(userName);
        if (user != null && user.getUserName().equals(userName) && user.getUserPass().equals(userPass)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * The method returns a list of all users in database.
     * @return list of users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            users = session.createCriteria(User.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return users;
    }

    /**
     * The method deletes the user from database.
     * @param user
     */
    public void deleteUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    /**
     * The method returns user info by username.
     * @param userName
     * @return user object
     */
    public User getUserByUserName(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            user = (User) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * The method adds user to database.
     * @param user
     * @return true or false
     */
    public boolean register(User user){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        if(isUserExists(user)) return false;
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e);
        } finally {
            session.close();
        }
        return true;
    }

    /**
     * The method checks whether the user exists in database
     * @param user
     * @return true or false
     */
    public boolean isUserExists(User user){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        boolean result = false;
        String userName = user.getUserName();
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            User u = (User) criteria.uniqueResult();
            tx.commit();
            if(u!=null) result = true;
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
}
