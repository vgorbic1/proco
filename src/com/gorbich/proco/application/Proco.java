package com.gorbich.proco.application;

import com.gorbich.proco.entity.Question;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.QuestionDaoHibernate;
import com.gorbich.proco.persistence.UserDaoHibernate;

import java.util.List;
import java.util.Properties;

/**
 * Class Proco
 * This is the main class for the application.
 * The class communicates with Hibernate.
 * @author Vlad Gorbich.
 */
public class Proco {
    private Properties properties;

    /**
     * Empty Constructor.
     */
    public Proco() {}


    /**
     * Overloaded Constructor.
     * The constructor loads Properties file.
     */
    public Proco(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * The method gets Author name from the Properties file.
     * @return Author's name.
     */
    public String getAuthor() {
        String author = properties.getProperty("author");
        return author;
    }


    /**
     * The method requests Hibernate to return all questions in the table.
     * @return List of questions.
     */
    public List<Question> getAllQuestions(){
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        List<Question> questions = questionHibernate.getAllQuestions();
        return questions;
    }


    /**
     * The method adds new questions in the table.
     * @return Id of updated question.
     */
    public int addQuestion(String category, String level, String inquiry, String answer) {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        int insertedQuestionId;
        Question question = new Question();
        question.setCategory(category);
        question.setLevel(level);
        question.setInquiry(inquiry);
        question.setAnswer(answer);
        insertedQuestionId = questionHibernate.addQuestion(question);
        return insertedQuestionId;
    }


    /**
     * The method returns the question by submitted question id.
     * @return The question.
     */
    public Question getQuestionById(int questionId) {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = questionHibernate.getQuestionById(questionId);
        return question;
    }

    /**
     * The method returns the limited list of questions
     * based on the provided category.
     * The questions in the list are in random order.
     * @return The List of questions
     */
    public List<Question> getSpecificCategoryRandomQuestionsWithLimit(String category, int limit) {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        List<Question> questions = questionHibernate.getSpecificCategoryRandomQuestionsWithLimit(category, limit);
        return questions;
    }


    /**
     * The method updates question in the database.
     * @param questionId
     * @param category
     * @param level
     * @param inquiry
     * @param answer
     */
    public void updateQuestion(int questionId, String category, String level, String inquiry, String answer) {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        question.setQuestionId(questionId);
        question.setCategory(category);
        question.setLevel(level);
        question.setInquiry(inquiry);
        question.setAnswer(answer);
        questionHibernate.updateQuestion(question);
    }

    /**
     * The method requests Hibernate to return all users in the table.
     * @return List of users.
     */
    public List<User> getAllUsers(){
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        List<User> users = userHibernate.getAllUsers();
        return users;
    }
}
