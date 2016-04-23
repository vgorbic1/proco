package com.gorbich.proco.servlet;

import com.gorbich.proco.entity.Challenge;
import com.gorbich.proco.entity.Result;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.ChallengeDaoHibernate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vlad on 3/26/2016.
 */
public class TestSave extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String category;
        if (user!=null) {
            String userName = user.getUserName();
            category = (String) session.getAttribute("category");
            int totalQuestions = (Integer) session.getAttribute("limit");

            List<Result> results = (List<Result>) session.getAttribute("results");
            int correctQuestions = 0;
            for (Result result : results) {
                if (result.getResult().equals("correct")) {
                    correctQuestions++;
                }
            }
            ChallengeDaoHibernate challengeHibernate = new ChallengeDaoHibernate();
            Challenge challenge = new Challenge();
            challenge.setUserName(userName);
            challenge.setCategory(category);
            challenge.setTotalQuestions(totalQuestions);
            challenge.setCorrectQuestions(correctQuestions);
            challengeHibernate.addChallenge(challenge);
            response.sendRedirect("stat");
        } else {
            response.sendRedirect("login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
