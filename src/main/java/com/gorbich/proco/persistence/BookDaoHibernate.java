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
 * DAO Hibernate to map Books entity.
 */
public class BookDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Book.class);
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


    /**
     * The method adds new book to database.
     * @param book
     * @return book id
     */
    public int addBook(Book book) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer bookId = null;
        try {
            tx = session.beginTransaction();
            bookId = (Integer) session.save(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return bookId;
    }

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

    /**
     * The method deletes the user from database.
     * @param book
     */
    public void deleteBook(Book book) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }
}