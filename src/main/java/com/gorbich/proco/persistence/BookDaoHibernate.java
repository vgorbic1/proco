package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO to map Books entity.
 */
public class BookDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The method gets all Books in database.
     * @return list of books
     */
    public List<Book> getAllBooks() {
        List<Book> books;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        books = criteria.list();
        session.close();
        return books;
    }

    /**
     * The method gets all Books in database from specific category.
     * @param category
     * @return list of books
     */
    public List<Book> getBooksByCategory(String category) {
        List<Book> books = new ArrayList<Book>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Book.class);
            criteria.add(Restrictions.eq("category", category));
            books = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return books;
    }

}