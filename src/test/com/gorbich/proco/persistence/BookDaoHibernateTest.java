package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Book;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Tests for Book Dao.
 */
public class BookDaoHibernateTest extends TestCase {
    BookDaoHibernate bookHibernate;

    @Before
    public void setUp() throws Exception {
        bookHibernate = new BookDaoHibernate();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = bookHibernate.getAllBooks();
        assertTrue(books.size() > 0);
    }

    @Test
    public void testGetBooksByCategory() throws Exception {
        String category = "SQL";
        List<Book> books = bookHibernate.getBooksByCategory(category);
        assertTrue(books.size() > 0);
    }

}