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
 * Rest Client Web Service.
 * Sends request to isbndb.com site and
 * gets book information.
 */

public class RestClient {

    /**
     * The method gets book information from web service
     * @param url
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws MalformedURLException
     * @throws IOException
     */
    public List<String> getBookInfo(String url) throws JsonParseException,
            JsonMappingException, MalformedURLException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Book books = mapper.readValue(new URL(url), Book.class);
        return getData(books);
    }

    /**
     * The method gets book data.
     * @param books
     * @return
     */
    private List<String> getData(Book books) {
        String bookTitle;
        String bookPublisher;
        String bookAuthor;
        Data[] datasets = books.getData();
        List<String> bookInfo = new ArrayList<String>();
        for (Data data : datasets) {
            bookTitle = data.getTitle();
            bookPublisher = data.getPublisher_name();
            bookAuthor = getAuthor(data);
            bookInfo.add(bookTitle);
            bookInfo.add(bookPublisher);
            bookInfo.add(bookAuthor);
        }
        return bookInfo;
    }

    /**
     * The method gets author(s) information and formats the string
     * @param data
     * @return
     */
    private String getAuthor(Data data) {
        String bookAuthor = "";
        Author_Data[] author_names = data.getAuthor_data();
        for (Author_Data author_data : author_names) {
            String author = author_data.getName();
            // Split and reverse author's full name
            List<String> authorFullName = Arrays.asList(author.split(","));
            Collections.reverse(authorFullName);
            for (String s : authorFullName) {
                bookAuthor += s + " ";
            }
            // Remove trailing space
            bookAuthor = bookAuthor.replaceAll("\\s+$", "");
            bookAuthor += ", ";
        }
        return bookAuthor;
    }
}
