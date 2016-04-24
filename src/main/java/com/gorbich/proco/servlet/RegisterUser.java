package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.application.Validator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Register User servlet
 * The servlet checks if the username and password is valid
 * and registers the user.
 */
public class RegisterUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = request.getParameter("username").toLowerCase();
        String userPass = request.getParameter("password");
        String url = "/register";

        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        String message = proco.registerUser(userName, userPass);

        if (message.equals("Registration Successful")) {
            url = "/login";
        }

        /*message = Validator.validateUsername(userName);
        if (message == null) {
            message = Validator.validatePassword(userPass);
        }
        if (message == null ) {
            ServletContext context = getServletContext();
            Proco proco = (Proco)context.getAttribute("proco");
            boolean result = proco.registerUser(userName, userPass);
            if (result) {
                message = "Registration Successful";
                url = "/login";
            } else {
                message = "Username is already taken";
            }
        }*/

        session.setAttribute("registerMessage", message);
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