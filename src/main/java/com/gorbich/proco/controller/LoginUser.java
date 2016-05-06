package com.gorbich.proco.controller;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Login User controller
 * Provides logging in the application
 * and saving test results
 */
public class LoginUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = request.getParameter("username").toLowerCase();
        String userPass = request.getParameter("password");
        String message = "";
        String url;

        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        User user = proco.authenticateUser(userName, userPass);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            List<Result> results = (List<Result>) session.getAttribute("results");
            if (results != null) {
                String category = (String) session.getAttribute("category");
                int totalQuestions = (Integer) session.getAttribute("limit");
                proco.saveTestResults(userName, category, totalQuestions, results);
                message = "test results saved!";
                session.setAttribute("statMessage", message);
            }
            // Cleanup
            session.removeAttribute("results");
            session.removeAttribute("limit");
            session.removeAttribute("category");
            url = "/stat";
        } else {
            message = "invalid username or password";
            url = "/login";
        }

        request.getSession().setAttribute("loginMessage", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
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
