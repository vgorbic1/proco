package com.gorbich.proco.service;

import java.util.Arrays;

/**
 * Book bean.
 * Contains data array of book information.
 */
public class Book {
    private Data[] data;

    /**
     * Empty Constructor
     */
    public Book() {
    }

    /**
     * Constructor to load property
     * @param data
     */
    public Book(Data[] data) {
        this.data = data;
    }

    /**
     * Getter for Book Data
     * @return data
     */
    public Data[] getData() {
        return data;
    }

    /**
     * Setter for Book Data
     * @param data
     */
    public void setData(Data[] data) {
        this.data = data;
    }

}

