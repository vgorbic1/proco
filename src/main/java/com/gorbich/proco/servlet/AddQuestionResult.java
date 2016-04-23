package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.application.Validator;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.persistence.QuestionDaoHibernate;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Add Question Result servlet.
 * Gets user's input, checks whether it is empty or not.
 * Adds the question to the list of all questions.
 * Notifies the user on result.
 */
public class AddQuestionResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        String level = request.getParameter("level");
        String inquiry = request.getParameter("question");
        String answer = request.getParameter("answer");
        HttpSession session = request.getSession();

        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        String resultMessage = proco.addQuestion(category, level, inquiry, answer);

        session.setAttribute("answer", answer);
        session.setAttribute("inquiry", inquiry);
        session.setAttribute("message", resultMessage);
        response.sendRedirect("question-add");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}