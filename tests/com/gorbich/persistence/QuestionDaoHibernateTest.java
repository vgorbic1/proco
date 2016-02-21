package com.gorbich.persistence;

import com.gorbich.entity.Question;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vlad on 2/21/2016.
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
        question.setQuestionBody("Test Update Question");
        question.setAnswer("Test Update Answer");
        question.setImage("Test Update Image");
        question.setLevel("Test Update Level");
        questionHibernate.updateQuestion(question);
        assertEquals(1, question.getQuestionId());
        assertEquals("Test Update Question", question.getQuestionBody());
    }

    @Test
    public void testDeleteQuestion() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        // To have the test pass make sure ID exists in database
        question.setQuestionId(1);
        questionHibernate.deleteQuestion(question);
        List<Question> employees = questionHibernate.getAllQuestions();
        for (Question testEmployee : employees){
            assertFalse(testEmployee.getQuestionId() == 1);
        }
    }

    @Test
    public void testAddQuestion() throws Exception {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        int insertedQuestionId;
        Question question = new Question();
        question.setQuestionBody("Test Add Question");
        question.setAnswer("Test Add Answer");
        question.setImage("Test Image URL");
        question.setLevel("Test Add Level");
        insertedQuestionId = questionHibernate.addQuestion(question);
        assertTrue(insertedQuestionId > 0);
    }
}