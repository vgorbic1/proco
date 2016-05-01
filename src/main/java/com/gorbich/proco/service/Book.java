package com.gorbich.proco.service;

import java.util.Arrays;

/**
 * Created by Vlad on 4/29/2016.
 */
public class Book {
    private Data[] data;

    public Book() {
    }

    public Book(Data[] data) {
        this.data = data;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Book{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}

