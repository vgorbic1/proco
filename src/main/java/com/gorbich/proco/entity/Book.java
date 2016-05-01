package com.gorbich.proco.entity;

/**
 * Created by Vlad on 4/29/2016.
 */
public class Book {
    private int bookId;
    private String isbn;
    private String category;

    public Book() {
    }

    public Book(int bookId, String isbn, String category) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.category = category;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
