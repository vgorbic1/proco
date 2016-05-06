package com.gorbich.proco.entity;

/**
 * Book Bean.
 * The class represents Books in database.
 */
public class Book {
    private int bookId;
    private String isbn;
    private String category;

    /**
     * Empty constructor
     */
    public Book() {
    }

    /**
     * Constructor to load all properties
     * @param bookId
     * @param isbn
     * @param category
     */
    public Book(int bookId, String isbn, String category) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.category = category;
    }

    /**
     * Getter for BookId
     * @return bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Setter for BookId
     * @param bookId
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Getter for ISBN
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter for ISBN
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter for Category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for Category
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
