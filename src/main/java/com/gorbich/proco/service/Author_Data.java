package com.gorbich.proco.service;

/**
 * Author Data bean.
 * Contains author or author information.
 */
public class Author_Data {
    private String name;

    /**
     * Empty Constructor
     */
    public Author_Data() {}

    /**
     * Constructor to Load Properties
     * @param name
     */
    public Author_Data(String name) {
        this.name = name;
    }

    /**
     * Getter for Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
