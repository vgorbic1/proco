package com.gorbich.proco.application;

import com.gorbich.proco.entity.Challenge;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.ChallengeDaoHibernate;
import com.gorbich.proco.persistence.QuestionDaoHibernate;
import com.gorbich.proco.persistence.UserDaoHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

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
     * The method adds new question to database.
     * @return String success or error message.
     */
    public String addQuestion(String category, String level, String inquiry, String answer) {
        String resultMessage;
        if (Validator.fieldIsEmpty(inquiry)) {
            return "Question field is empty";
        }
        if (Validator.fieldIsEmpty(answer)) {
            return "Answer field is empty";
        }
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        question.setCategory(category);
        question.setLevel(level);
        question.setInquiry(inquiry);
        question.setAnswer(answer);
        int insertedQuestionId = questionHibernate.addQuestion(question);
        if (insertedQuestionId == 0) {
            resultMessage = "Failed to add the Question";
        } else {
            resultMessage = "Question was successfully added";
        }
        return resultMessage;
    }

    public User authenticateUser(String userName, String userPass) {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        User user = null;
        boolean result = userHibernate.authenticate(userName, userPass);
        if (result) {
            user = userHibernate.getUserByUserName(userName);
        }
        return user;
    }

    public String saveResults(List<Result> results, String userName, String category, int totalQuestions) {
        int correctQuestions = 0;
        for (Result res : results) {
            if (res.getResult().equals("correct")) {
                correctQuestions++;
            }
        }
        ChallengeDaoHibernate challengeHibernate = new ChallengeDaoHibernate();
        Challenge challenge = new Challenge();
        challenge.setUserName(userName);
        challenge.setCategory(category);
        challenge.setTotalQuestions(totalQuestions);
        challenge.setCorrectQuestions(correctQuestions);
        challengeHibernate.addChallenge(challenge);
        return "Test Results Saved!";
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




    public void deleteQuestion(int questionId) {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        question.setQuestionId(questionId);
        questionHibernate.deleteQuestion(question);
    }

    public void deleteUser(int userId) {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        User user = new User();
        user.setUserId(userId);
        userHibernate.deleteUser(user);
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


    public Search getSearchQuestionsResults(int page) {
        Search search = new Search();
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        int pageSize = Integer.parseInt(properties.getProperty("numberOfQuestionsPerPage"));
        List questions = questionHibernate.getAllQuestionsWithPagination(page, pageSize);
        if (questions.size() != 0) {
            search.setSuccess(true);
        }
        search.setSearchResults(questions);
        Long totalNumberOfQuestions = questionHibernate.getTotalNumberOfQuestions();
        search.setTotalNumberOfQuestions(totalNumberOfQuestions);
        getPagination(search, page, totalNumberOfQuestions, pageSize);
        return search;
    }

    /**
     * The method requests Hibernate to return search results with pagination.
     * @return search.
     */
    public Search getSearchQuestionsResults(String column, String searchTerm, int page) {
        Search search = new Search();
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        int pageSize = Integer.parseInt(properties.getProperty("numberOfQuestionsPerPage"));
        List questions = questionHibernate.getSearchQuestionsWithPagination(column, searchTerm, page, pageSize);
        if (questions.size() != 0) {
            search.setSuccess(true);
        }
        search.setSearchResults(questions);
        Long totalNumberOfQuestions = questionHibernate.getSearchTotalNumberOfEntries(column, searchTerm);
        search.setTotalNumberOfQuestions(totalNumberOfQuestions);
        getPagination(search, page, totalNumberOfQuestions, pageSize);
        return search;
    }

    private void getPagination(Search search, int page, Long totalNumberOfQuestions, int pageSize) {
        int totalPages = ((int) (long) totalNumberOfQuestions / pageSize) + 1;
        search.setTotalNumberOfPages(totalPages);
        int beginPage = page - 5;
        int endPage = page + 4;
        if (beginPage <= 0) {
            endPage -= (beginPage - 1);
            beginPage = 1;
        }
        if (endPage > totalPages) {
            endPage = totalPages;
            if (endPage > 10) {
                beginPage = endPage - 9;
            }
        }
        search.setBeginPage(beginPage);
        search.setEndPage(endPage);
    }
}
