package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Question;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Tests for Question Dao
 */
public class QuestionDaoHibernateTest extends TestCase {
    QuestionDaoHibernate questionHibernate;

    @Before
    public void setUp() {
        questionHibernate = new QuestionDaoHibernate();
    }

    @Test
    public void testGetAllQuestionsWithPagination() throws Exception {
        int page = 1;
        int pageSize = 1;
        List<Question> questions =  questionHibernate.getAllQuestionsWithPagination(page, pageSize);
        assertTrue(questions.size() > 0);
    }

    @Test
    public void testGetTotalNumberOfQuestions() throws Exception {
        Long result = questionHibernate.getTotalNumberOfQuestions();
        assertTrue(result > 0);
    }

    @Test
    public void testGetSpecificCategoryRandomQuestionsWithLimit() throws Exception {
        String category = "SQL";
        int limit = 1;
        List<Question> result = questionHibernate.getSpecificCategoryRandomQuestionsWithLimit(category, limit);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetQuestionById() throws Exception {
        int questionId = 2; // Make sure a question with such ID exists in database
        Question question = questionHibernate.getQuestionById(questionId);
        int result = question.getQuestionId();
        assertTrue(result == 2);
    }

    @Test
    public void testGetSearchQuestionsWithPagination() throws Exception {
        String column = "answer";
        String searchTerm = "List";
        int page = 1;
        int pageSize = 10;
        List<Question> result = questionHibernate.getSearchQuestionsWithPagination(column, searchTerm, page, pageSize);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetSearchTotalNumberOfEntries() throws Exception {
        String column = "answer";
        String searchTerm = "List";
        Long result = questionHibernate.getSearchTotalNumberOfEntries(column, searchTerm);
        assertTrue(result > 0);
    }

    @Test
    public void testUpdateQuestion() throws Exception {
        Question question = new Question();
        question.setQuestionId(471); // make sure that ID corresponds to the test question in database
        question.setAnswer("testAnswer");
        question.setInquiry("testInquiry");
        question.setLevel("testLevel");
        question.setCategory("testCategory");
        questionHibernate.updateQuestion(question);
        Question result = questionHibernate.getQuestionById(471);
        assertTrue(result.getAnswer().equals("testAnswer"));
    }
}