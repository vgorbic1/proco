package com.gorbich.proco.application;

import com.gorbich.proco.entity.Book;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Proco class.
 */
public class ProcoTest extends TestCase {
    Proco proco;
    Properties properties;
    public final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        proco = new Proco(properties);
    }

    @Test
    public void testAddQuestion() throws Exception {
        String category = "test";
        String level = "test";
        String inquiry = "test";
        String answer = "test";
        String result = proco.addQuestion(category, level, inquiry, answer);
        assertTrue(result.equals("Question was successfully added"));
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        String userName = "testuser";
        String userPass = "testPass";
        //User user = proco.authenticateUser(userName, userPass);
        //assertTrue(user.equals(null));
    }

    @Test
    public void testRegisterUser() throws Exception {
        String userName = "testuser";
        String userPass = "testPass";
        //String result = proco.registerUser(userName, userPass);
        //log.info(result);
    }

    @Test
    public void testSaveTestResults() throws Exception {
        String userName = "testName";
        String category = "SQL";
        int totalQuestions = 1;
        Result result = new Result();
        result.setResult("correct");
        List<Result> results = new ArrayList<Result>();
        results.add(result);
        proco.saveTestResults(userName, category, totalQuestions, results);
        //log.info();

    }

    @Test
    public void testDeleteQuestion() throws Exception {
        int questionId = 1;
        proco.deleteQuestion(questionId);
        // count number of questions before and after
    }

    @Test
    public void testDeleteUser() throws Exception {
        int userId = 3;
        proco.deleteUser(userId);
        // count number of users before and after
    }

    @Test
    public void testGetQuestionById() throws Exception {
        int questionId = 1;
        Question question = proco.getQuestionById(questionId);
        //log.info(question.getQuestionId());
    }

    @Test
    public void testGetSpecificCategoryRandomQuestionsWithLimit() throws Exception {
        String category = "SQL";
        int limit = 1;
        List<Question> questions = proco.getSpecificCategoryRandomQuestionsWithLimit(category, limit);
        //
    }

    @Test
    public void testUpdateQuestion() throws Exception {

    }

    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testGetSearchQuestionsResults() throws Exception {

    }

    @Test
    public void testGetAllBooks() throws Exception {

    }

    @Test
    public void testAddBook() throws Exception {

    }

    @Test
    public void testGetBooks() throws Exception {
        Proco proco = new Proco();
        List<List> list = proco.getBooks("Java");
        log.info(list);
    }

    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
            log.error(ioException);
        } catch(Exception exception) {
            log.error(exception);
        }
    }

}