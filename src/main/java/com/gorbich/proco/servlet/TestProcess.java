package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.entity.Result;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Test Process servlet.
 * Returns randomized list of questions of specified category.
 * The list is limited by specified parameter.
 */
public class TestProcess extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        Proco proco = (Proco) context.getAttribute("proco");

        if (session.getAttribute("challengeQuestions") == null) {
            ArrayList<Result> results = new ArrayList<Result>();
            session.setAttribute("results", results);
            String category = request.getParameter("category");
            session.setAttribute("category", category);
            int limit = Integer.parseInt(request.getParameter("limit"));
            session.setAttribute("limit", limit);
            session.setAttribute("totalNumberOfQuestions", limit);

            List<Question> questions = proco.getSpecificCategoryRandomQuestionsWithLimit(category, limit);
            session.setAttribute("challengeQuestions", questions);

            int questionNumber = 0;
            Question currentQuestion = questions.get(questionNumber);
            questionNumber++;
            session.setAttribute("number", questionNumber);
            session.setAttribute("question", currentQuestion);

        } else {
            int questionNumber = (Integer) session.getAttribute("number");
            if (questionNumber < (Integer) session.getAttribute("totalNumberOfQuestions")) {
                List<Result> results = addResultToResultList(request, session, questionNumber);
                session.setAttribute("results", results);
                List<Question> questions = (List<Question>) session.getAttribute("challengeQuestions");
                Question currentQuestion = questions.get(questionNumber);
                session.setAttribute("question", currentQuestion);
            } else {
                List<Result> results = addResultToResultList(request, session, questionNumber);
                List<List> requestedBooks = proco.getBooks((String)session.getAttribute("category"));
                session.setAttribute("books", requestedBooks);
                session.setAttribute("results", results);
                session.removeAttribute("challengeQuestions");
                session.removeAttribute("question");
            }
            questionNumber++;
            session.setAttribute("number", questionNumber);
        }
        response.sendRedirect("test-action");
    }


    /**
     * The method constructs result list
     * @param request
     * @param session
     * @return result list
     */
    private List<Result> addResultToResultList(HttpServletRequest request, HttpSession session, int questionNumber) {
        Question q = (Question) session.getAttribute("question");
        Result result = new Result();
        result.setQuestionNumber(questionNumber);
        result.setLevel(q.getLevel());
        result.setInquiry(q.getInquiry());
        result.setAnswer(q.getAnswer());
        String resultParameter = (request.getParameter("correct") != null) ? "correct" : "incorrect";
        result.setResult(resultParameter);
        List<Result> results = (List<Result>) session.getAttribute("results");
        results.add(result);
        return results;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
