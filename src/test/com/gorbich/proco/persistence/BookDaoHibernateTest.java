package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Book;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Vlad on 4/29/2016.
 */
public class BookDaoHibernateTest extends TestCase {
    public final Logger log = Logger.getLogger(this.getClass());
    public void testGetAllBooks() throws Exception {
        BookDaoHibernate bookHibernate = new BookDaoHibernate();
        List<Book> book = bookHibernate.getAllBooks();
        log.info(book);
    }

    public void testAddBook() throws Exception {

    }

    public void testGetBooksByCategory() throws Exception {
    BookDaoHibernate bookHibernate = new BookDaoHibernate();
        List<Book> book = bookHibernate.getBooksByCategory("SQL");
        log.info(book.toString());
    }

}