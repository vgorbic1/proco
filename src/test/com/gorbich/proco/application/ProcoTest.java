package com.gorbich.proco.application;

import com.gorbich.proco.entity.Book;
import junit.framework.TestCase;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Vlad on 4/29/2016.
 */
public class ProcoTest extends TestCase {
    public final Logger log = Logger.getLogger(this.getClass());

    public void testAddQuestion() throws Exception {

    }

    public void testAuthenticateUser() throws Exception {

    }

    public void testRegisterUser() throws Exception {

    }

    public void testSaveTestResults() throws Exception {

    }

    public void testDeleteQuestion() throws Exception {

    }

    public void testDeleteUser() throws Exception {

    }

    public void testGetQuestionById() throws Exception {

    }

    public void testGetSpecificCategoryRandomQuestionsWithLimit() throws Exception {

    }

    public void testUpdateQuestion() throws Exception {

    }

    public void testGetAllUsers() throws Exception {

    }

    public void testGetSearchQuestionsResults() throws Exception {

    }

    public void testGetSearchQuestionsResults1() throws Exception {

    }

    public void testGetAllBooks() throws Exception {

    }

    public void testAddBook() throws Exception {

    }

    public void testGetBooks() throws Exception {
        Proco proco = new Proco();
        List<List> list = proco.getBooks("Java");
        log.info(list);
    }

}