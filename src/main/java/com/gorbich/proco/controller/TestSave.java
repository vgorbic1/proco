package com.gorbich.proco.controller;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Save Test controller
 * The test saves result of the test if user is registered.
 * If not, the controller redirects to login page.
 */
public class TestSave extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String userName = user.getUserName();
            String category = (String) session.getAttribute("category");
            int totalQuestions = (Integer) session.getAttribute("limit");
            List<Result> results = (List<Result>) session.getAttribute("results");
            ServletContext context = getServletContext();
            Proco proco = (Proco)context.getAttribute("proco");
            proco.saveTestResults(userName, category, totalQuestions, results);
            response.sendRedirect("stat");
        } else {
            response.sendRedirect("login");
        }
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
