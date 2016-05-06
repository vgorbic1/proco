package com.gorbich.proco.persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Generic DAO
 */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Constructor to load a class type
     * @param type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * This generic method adds an object to database
     * @param object
     * @return Id of the added object
     */
    public int add(T object) {
        Session session = getSession();
        Transaction tx = null;
        Integer objectId = null;
        try {
            tx = session.beginTransaction();
            objectId = (Integer) session.save(object);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return objectId;
    }

    /**
     * This generic method deletes an object from database.
     * @param object
     */
    public void delete(T object) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(object);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
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
