package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 3/4/2016.
 */
public class UserDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    public boolean authenticate(String userName, String userPass) {
        User user = getUserByUserName(userName);
        if (user != null && user.getUserName().equals(userName) && user.getUserPass().equals(userPass)){
            return true;
        }else{
            return false;
        }
    }

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

    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
            log.info("User updated");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deleteUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            log.info("User deleted");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    public int addUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer testUserId = null;
        try {
            tx = session.beginTransaction();
            testUserId = (Integer) session.save(user);
            tx.commit();
            log.info("Added user: " + user + " with id of: " + testUserId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return testUserId;
    }

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
            //Query query = session.createQuery("from User where userName = :userName");
            //query.setParameter("userName", userName);
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
