package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");
        String level = request.getParameter("level");
        String inquiry = request.getParameter("question");
        String answer = request.getParameter("answer");
        boolean success = true;
        String resultMessage = "";

        HttpSession session = request.getSession();

        if (inquiry == "" || inquiry == null) {
            resultMessage = "<p class=\"error\">Question is empty.</p>";
            success = false;
            session.setAttribute("answer", answer);
        }

        if (answer == "" || answer == null) {
            resultMessage += "<p class=\"error\">Answer is empty.</p>";
            success = false;
            session.setAttribute("inquiry", inquiry);
        }

        if (success) {
            ServletContext context = getServletContext();
            Proco proco = (Proco)context.getAttribute("proco");
            int insertedQuestionId = proco.addQuestion(category, level, inquiry, answer);

            if (insertedQuestionId == 0) {
                resultMessage = "<p class='error'>Failed to add the Question</p>";
            } else {
                resultMessage = "<p class='success'>Question was successfully added</p>";
            }
        }

        session.setAttribute("message", resultMessage);

        String url = "question-add";
        response.sendRedirect(url);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}