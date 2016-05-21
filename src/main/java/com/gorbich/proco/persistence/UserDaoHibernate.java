package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import java.util.List;

/**
 * DAO to map User entity.
 */
public class UserDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The method returns a list of all users in database.
     * @return list of users
     */
    public List<User> getAllUsers() {
        Session session = getSession();
        List<User> users;
        users = session.createCriteria(User.class).list();
        session.close();
        return users;
    }

    /**
     * The method returns user info by username.
     * @param userName
     * @return user object
     */
    public User getUserByUserName(String userName) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    /**
     * The method returns user info by user Id.
     * @param userId
     * @return user object
     */
    public User getUserByUserId(int userId) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userId", userId));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    /**
     * The method returns user salt encryption info by user name.
     * @param userName
     * @return salt
     */
    public byte[] getUserSalt(String userName) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        User user = (User) criteria.uniqueResult();
        byte[] salt = user.getSalt();
        session.close();
        return salt;
    }

    /**
     * The method returns user encrypted password info by user name.
     * @param userName
     * @return encrypted pass
     */
    public byte[] getUserEncryptedPass(String userName) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        User user = (User) criteria.uniqueResult();
        byte[] encryptedPass = user.getUserPass();
        session.close();
        return encryptedPass;
    }

    /**
     * The method adds user to database.
     * @param user
     * @return true or false
     */
    public boolean register(User user){
        Session session = getSession();
        if(isUserExist(user)) return false;
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
    public boolean isUserExist(User user){
        Session session = getSession();
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
     * Utility method to create Hibernate session.
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
