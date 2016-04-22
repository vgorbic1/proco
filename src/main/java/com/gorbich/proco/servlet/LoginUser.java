package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Validator;
import com.gorbich.proco.entity.Challenge;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.ChallengeDaoHibernate;
import com.gorbich.proco.persistence.UserDaoHibernate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vlad on 3/20/2016.
 */
public class LoginUser extends HttpServlet {
    //private final Logger log = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = request.getParameter("username").toLowerCase();
        String userPass = request.getParameter("password");
        String message = "";
        String url = "/login";

        // Move to Proco class
        UserDaoHibernate userHibernate = new UserDaoHibernate();
        boolean result = userHibernate.authenticate(userName, userPass);
        User user = userHibernate.getUserByUserName(userName);
        if (result == true) {
            request.getSession().setAttribute("user", user);
            List<Result> testResults = (List<Result>) session.getAttribute("results");
            if (testResults != null) {
                // save test results to database
                String category = (String) session.getAttribute("category");
                int totalQuestions = (Integer) session.getAttribute("limit");

                List<Result> results = (List<Result>) session.getAttribute("results");
                int correctQuestions = 0;
                for (Result res : results) {
                    if (res.getResult().equals("correct")) {
                        correctQuestions++;
                    }
                }
                ChallengeDaoHibernate challengeHibernate = new ChallengeDaoHibernate();
                Challenge challenge = new Challenge();
                challenge.setUserName(userName);
                challenge.setCategory(category);
                challenge.setTotalQuestions(totalQuestions);
                challenge.setCorrectQuestions(correctQuestions);
                int challengeId = challengeHibernate.addChallenge(challenge);
                message = "Test Results Saved!";

                // Cleanup
                session.removeAttribute("results");
                session.removeAttribute("limit");
                session.removeAttribute("category");

                request.getSession().setAttribute("statMessage", message);
            }
            url = "/stat";
        } else {
            message = "Invalid username/password combination.";
        }

        request.getSession().setAttribute("loginMessage", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
