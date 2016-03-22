package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Validate;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Vlad on 3/20/2016.
 */
public class LoginUser extends HttpServlet {
    //private final Logger log = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "";
        String url = "/user-login.jsp";
        boolean success = true;

        HttpSession session = request.getSession();

        if (password == null || password == "") {
            message = "enter password";
            success = false;
            session.setAttribute("loginMessage", message);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        }

        if (username == null || username == "") {
            message = "enter username";
            success = false;
            session.setAttribute("loginMessage", message);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        }

        if (success) {
            /*Validate validate = new Validate();
            boolean userId = validate.checkUser(username, password);
            if ( userId ) {
                session.setAttribute("userId", userId);
                url = "/user-stat.jsp";
            } else {
                message = "Login Failed";
                session.setAttribute("loginMessage", message);
                session.removeAttribute("username");
                session.removeAttribute("password");
            }*/
        }


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
