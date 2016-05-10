package com.gorbich.proco.application;

import com.gorbich.proco.entity.*;
import com.gorbich.proco.persistence.ChallengeDaoHibernate;
import com.gorbich.proco.persistence.UserDaoHibernate;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Proco class.
 */
public class ProcoTest extends TestCase {
    Proco proco;
    Properties properties;
    public final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        loadProperties("/proco.properties");
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
        String userPass = "testUser";
        User user = proco.authenticateUser(userName, userPass);
        assertTrue(user.getUserName().equals(userName));
    }

    @Test
    public void testRegisterUser() throws Exception {
        String userName = "testuser";
        String userPass = "testUser";
        String result = proco.registerUser(userName, userPass);
        assertTrue(result.equals("Username is already taken"));
    }

    @Test
    public void testSaveTestResults() throws Exception {
        String userName = "testuser";
        String category = "SQL";
        int totalQuestions = 1;
        Result result = new Result();
        result.setResult("correct");
        List<Result> results = new ArrayList<Result>();
        results.add(result);
        proco.saveTestResults(userName, category, totalQuestions, results);
        ChallengeDaoHibernate challenge = new ChallengeDaoHibernate();
        List<Challenge> challenges = challenge.getChallengesByUsername(userName);
        assertTrue(challenges.size() > 0);
    }

    @Test
    public void testDeleteQuestion() throws Exception {
        int questionId = 471; //set a question ID of a test question
        proco.deleteQuestion(questionId);
        assertTrue(proco.getQuestionById(471) == null);
    }

    @Test
    public void testDeleteUser() throws Exception {
        int userId = 10; // make sure user exists in database
        proco.deleteUser(userId);
        UserDaoHibernate dao = new UserDaoHibernate();
        assertTrue(dao.getUserByUserId(userId) == null);
    }

    @Test
    public void testGetQuestionById() throws Exception {
        int questionId = 2; // make sure question exists in the database
        Question question = proco.getQuestionById(questionId);
        assertFalse(question == null);
    }

    @Test
    public void testGetSpecificCategoryRandomQuestionsWithLimit() throws Exception {
        String category = "SQL";
        int limit = 1;
        List<Question> questions = proco.getSpecificCategoryRandomQuestionsWithLimit(category, limit);
        assertTrue(questions.size() > 0);
    }

    @Test
    public void testUpdateQuestion() throws Exception {
        int questionId = 1;
        String category = "testCategory";
        String level = "testLevel";
        String inquiry = "testInquiry";
        String answer = "testAnswer";
        proco.updateQuestion(questionId, category, level, inquiry, answer);
        }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = proco.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void testGetSearchQuestionsResults() throws Exception {
        int page = 1;
        Search search = proco.getSearchQuestionsResults(page);
        assertTrue(search != null);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = proco.getAllBooks();
        assertTrue(books.size() > 0);
    }

    @Test
    public void testAddBook() throws Exception {
        String category = "testCategory";
        String isbn = "0000000000";
        String result = proco.addBook(category, isbn);
        assertTrue(result.equals("Book was successfully added"));
    }

    @Test
    public void testGetBooks() throws Exception {
        List<List> books = proco.getBooks("Java");
        assertTrue(books.size() > 0);
    }

    /**
     * Utility method to load properties.
     * @param propertiesFilePath
     */
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