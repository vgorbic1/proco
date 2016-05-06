package com.gorbich.proco.controller;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.application.Validator;
import com.gorbich.proco.entity.Question;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Update Question controller
 * Validates user's input and updates the question in database.
 */
public class UpdateQuestion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Question q = (Question) session.getAttribute("editQuestion");
        int questionId = q.getQuestionId();
        String category = request.getParameter("category");
        String level = request.getParameter("level");
        String inquiry = request.getParameter("question");
        String answer = request.getParameter("answer");
        boolean success = true;
        String resultMessage = "";
        if (Validator.fieldIsEmpty(inquiry)) {
            resultMessage = "Question field was empty. The saved Question is used.";
            success = false;
            session.setAttribute("answer", answer);
        }
        if (Validator.fieldIsEmpty(answer)) {
            resultMessage += "Answer field was empty. The saved Answer is used.";
            success = false;
            session.setAttribute("inquiry", inquiry);
        }
        if (success) {
            ServletContext context = getServletContext();
            Proco proco = (Proco)context.getAttribute("proco");
            proco.updateQuestion(questionId, category, level, inquiry, answer);
            resultMessage = "Question was successfully updated";
        }
        session.setAttribute("message", resultMessage);
        session.setAttribute("success", success);
        String url = "question-update-result";
        response.sendRedirect(url);
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