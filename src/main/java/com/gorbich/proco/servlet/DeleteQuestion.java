package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vlad on 4/18/2016.
 */
public class DeleteQuestion extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        proco.deleteQuestion(questionId);

        response.sendRedirect("/questions-all");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
