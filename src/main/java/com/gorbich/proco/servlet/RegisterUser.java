package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Validator;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.UserDaoHibernate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vlad on 3/11/2016.
 */
public class RegisterUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userName = request.getParameter("username").toLowerCase();
        String userPass = request.getParameter("password");
        String message;
        String url = "/register";

        message = Validator.validateUsername(userName);
        if (message == null) {
            message = Validator.validatePassword(userPass);
        }

        if (message == null ) {

            // Move to Proco
            User user = new User();
            UserDaoHibernate userDaoHibernate = new UserDaoHibernate();
            user.setUserName(userName);
            user.setUserPass(userPass);
            boolean result = userDaoHibernate.register(user);

            if (result) {
                message = "Registration Successful";
                url = "/login";
            } else {
                message = "Username is already taken";
            }
        }

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