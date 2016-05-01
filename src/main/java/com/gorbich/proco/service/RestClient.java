package com.gorbich.proco.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Vlad on 4/29/2016.
 */

public class RestClient {

    public List<String> getBookInfo(String isbn) throws JsonParseException,
            JsonMappingException, MalformedURLException, IOException {
        String url = "http://isbndb.com/api/v2/json/Y678NTDH/book/" + isbn; //0596009208
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Book books = mapper.readValue(new URL(url), Book.class);
        String bookTitle = "none";
        String bookPublisher = "none";
        String bookAuthor = "";

        Data[] datasets = books.getData();
        for (Data data : datasets) {
            bookTitle = data.getTitle();
            bookPublisher = data.getPublisher_name();
            Author_Data[] author_names = data.getAuthor_data();
            for (Author_Data author_data : author_names) {
                String author = author_data.getName();
                List<String> authorFullName = Arrays.asList(author.split(","));
                Collections.reverse(authorFullName);
                for (String s : authorFullName) {
                    bookAuthor += s + " ";
                }
                bookAuthor = bookAuthor.replaceAll("\\s+$", "");
                bookAuthor += ", ";
            }
        }

        List<String> bookInfo = new ArrayList<String>();
        bookInfo.add(bookTitle);
        bookInfo.add(bookPublisher);
        bookInfo.add(bookAuthor);
        return bookInfo;
    }

}
