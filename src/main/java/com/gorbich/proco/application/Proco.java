package com.gorbich.proco.application;

import com.gorbich.proco.entity.Challenge;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.BookDaoHibernate;
import com.gorbich.proco.persistence.ChallengeDaoHibernate;
import com.gorbich.proco.persistence.QuestionDaoHibernate;
import com.gorbich.proco.persistence.UserDaoHibernate;
import com.gorbich.proco.entity.Book;
import com.gorbich.proco.service.RestClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
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
    public final Logger log = Logger.getLogger(this.getClass());

    /**
     * Empty Constructor.
     */
    public Proco() {}

    /**
     * Overloaded Constructor.
     * The constructor loads Properties file.
     * @param properties
     */
    public Proco(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * The method adds new question to database.
     * @param category
     * @param level
     * @param inquiry
     * @param answer
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

    /**
     * The method authenticates a user.
     * @param userName
     * @param userPass
     * @return user object.
     */
    public User authenticateUser(String userName, String userPass) {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        User user = null;
        boolean result = userHibernate.authenticate(userName, userPass);
        if (result) {
            user = userHibernate.getUserByUserName(userName);
        }
        return user;
    }

    /**
     * The method registers a new user.
     * @param userName
     * @param userPass
     * @return true or false.
     */
    public String registerUser(String userName, String userPass) {
        String name = properties.getProperty("username");
        int min_user_chars = Integer.parseInt(properties.getProperty("min_user_characters"));
        int max_user_chars = Integer.parseInt(properties.getProperty("max_user_characters"));
        String allowed_user_chars = properties.getProperty("allowed_user_chars");

        String message = Validator.validate(userName, name, min_user_chars, max_user_chars, allowed_user_chars);
        if (message == null) {
            String pass = properties.getProperty("password");
            int min_pass_chars = Integer.parseInt(properties.getProperty("min_pass_characters"));
            int max_pass_chars = Integer.parseInt(properties.getProperty("max_pass_characters"));
            String allowed_pass_chars = properties.getProperty("allowed_pass_chars");
                    message = Validator.validate(userPass, pass, min_pass_chars, max_pass_chars, allowed_pass_chars);
        }
        if (message == null ) {
            User user = new User();
            UserDaoHibernate userDaoHibernate = new UserDaoHibernate();
            user.setUserName(userName);
            user.setUserPass(userPass);
            boolean result = userDaoHibernate.register(user);
            if (result) {
                message = "Registration Successful";
            } else {
                message = "Username is already taken";
            }
        }
        return message;
    }

    /**
     * The method saves test results in database.
     * @param userName
     * @param category
     * @param totalQuestions
     * @param results
     * @return confirmation.
    */
    public void saveTestResults(String userName, String category, int totalQuestions, List<Result> results) {
        int correctQuestions = 0;
        for (Result result : results) {
            if (result.getResult().equals("correct")) {
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
    }

    /**
     * The method requests Hibernate to delete a questions from database.
     * @param questionId
     */
    public void deleteQuestion(int questionId) {
        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        Question question = new Question();
        question.setQuestionId(questionId);
        questionHibernate.deleteQuestion(question);
    }

    /**
     * The method requests Hibernate to delete a user from database.
     * @param userId
     */
    public void deleteUser(int userId) {
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        User user = new User();
        user.setUserId(userId);
        userHibernate.deleteUser(user);
    }

    /**
     * The method returns the question by submitted question id.
     * @param questionId
     * @return The question object.
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
     * @param category
     * @param limit
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

    /**
     * The method requests Hibernate to return all questions related to search term.
     * @param page
     * @return search object.
     */
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
     * @param column
     * @param searchTerm
     * @param page
     * @return search object.
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

    /**
     * The method provides pagination logic.
     * @param search
     * @param page
     * @param totalNumberOfQuestions
     * @param pageSize
     */
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

    /**
     * The method requests Hibernate to return all books.
     * @return List of books.
     */
    public List<Book> getAllBooks(){
        BookDaoHibernate bookHibernate = new BookDaoHibernate();
        List<Book> books = bookHibernate.getAllBooks();
        return books;
    }

    /**
     * The method adds new book to database.
     * @param category
     * @param isbn
     * @return String success or error message.
     */
    public String addBook(String category, String isbn) {
        String resultMessage;
        if (Validator.fieldIsEmpty(category)) {
            return "Category field is empty";
        }
        if (Validator.fieldIsEmpty(isbn)) {
            return "ISBN field is empty";
        }
        if (Validator.fieldHasAlphabeticChars(isbn)) {
            return "ISBN field should contain numbers only";
        }
        BookDaoHibernate bookHibernate = new BookDaoHibernate();
        Book book = new Book();
        book.setCategory(category);
        book.setIsbn(isbn);
        int insertedBookId = bookHibernate.addBook(book);
        if (insertedBookId == 0) {
            resultMessage = "Failed to add the Book";
        } else {
            resultMessage = "Book was successfully added";
        }
        return resultMessage;
    }

    public List<List> getBooks(String category) throws IOException {
        List<List> listOfBooks = new ArrayList<List>();
        BookDaoHibernate bookHibernate = new BookDaoHibernate();
        List<Book> books = bookHibernate.getBooksByCategory(category);
        for (Book book : books) {
            String isbn = book.getIsbn();
            RestClient client = new RestClient();
            List<String> bookInfo = client.getBookInfo(isbn);
            listOfBooks.add(bookInfo);
        }
        return listOfBooks;
    }

    /**
     * The method requests Hibernate to delete a book from database.
     * @param bookId
     */
    public void deleteBook(int bookId) {
        BookDaoHibernate bookHibernate = new BookDaoHibernate();
        Book book = new Book();
        book.setBookId(bookId);
        bookHibernate.deleteBook(book);
    }
}