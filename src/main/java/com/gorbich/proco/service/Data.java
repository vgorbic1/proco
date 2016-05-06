package com.gorbich.proco.service;

/**
 * Data bean.
 * Contains information about each book.
 */
public class Data {
    private String title;
    private String publisher_name;
    private Author_Data author_data[];

    /**
     * Empty Constructor
     */
    public Data() {}

    /**
     * Constructor to load property
     * @param title
     */
    public Data(String title) {
        this.title = title;
    }

    /**
     * Getter for Book Title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for Book Title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for Book Publisher
     * @return publisher_name
     */
    public String getPublisher_name() {
        return publisher_name;
    }

    /**
     * Setter for Publisher Name
     * @param publisher_name
     */
    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    /**
     * Setter for Book Author(s) Info
     * @return author_data
     */
    public Author_Data[] getAuthor_data() {
        return author_data;
    }

    /**
     * Setter for Book Author(s) Info
     * @param author_data
     */
    public void setAuthor_data(Author_Data[] author_data) {
        this.author_data = author_data;
    }
}
