package com.gorbich.proco.service;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Vlad on 4/29/2016.
 */
public class Data {
    private String title;
    private String publisher_name;
    private Author_Data author_data[];

    public Data() {
    }

    public Data(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public Author_Data[] getAuthor_data() {
        return author_data;
    }

    public void setAuthor_data(Author_Data[] author_data) {
        this.author_data = author_data;
    }
}
