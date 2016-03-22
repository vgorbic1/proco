package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Question;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
/**
 * Created by Vlad on 3/3/2016.
 */
public class QuestionDaoHibernateTest {

    @Test
    public void testGetAllQuestions() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        List<Question> questions = questionHibernate.getAllQuestions();
        assertTrue(questions.size() > 0);
    }

    @Test
    public void testUpdateQuestion() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        // To make the test pass make sure ID exists in database
        question.setQuestionId(1);
        question.setCategory("Test Update Category");
        question.setLevel("Test Update Level");
        question.setInquiry("Test Update Inquiry");
        question.setAnswer("Test Update Answer");
        questionHibernate.updateQuestion(question);
        assertEquals(1, question.getQuestionId());
        assertEquals("Test Update Inquiry", question.getInquiry());
    }

    @Test
    public void testDeleteQuestion() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        // To have the test pass make sure ID exists in database
        question.setQuestionId(4);
        questionHibernate.deleteQuestion(question);
        List<Question> questions = questionHibernate.getAllQuestions();
        for (Question testQuestion : questions){
            assertFalse(testQuestion.getQuestionId() == 4);
        }
    }

    @Test
    public void testAddQuestion() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        int insertedQuestionId;
        Question question = new Question();
        question.setCategory("Test Add Category");
        question.setLevel("Test Add Level");
        question.setInquiry("Test Add Inquiry");
        question.setAnswer("Test Add Answer");
        insertedQuestionId = questionHibernate.addQuestion(question);
        assertTrue(insertedQuestionId > 0);
    }

    @Test
    public void getSpecificCategoryRandomQuestionsWithLimit() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        List<Question> questions = questionHibernate.getSpecificCategoryRandomQuestionsWithLimit("java", 1);
        assertTrue(questions.size() > 0);
    }

    @Test
    public void testGetQuestionById() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = questionHibernate.getQuestionById(1);
        assertTrue(question.getQuestionId() == 1);
    }
}
