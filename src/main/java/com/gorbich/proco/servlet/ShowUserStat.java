package com.gorbich.proco.servlet;

import com.gorbich.proco.entity.Challenge;
import com.gorbich.proco.entity.User;
import com.gorbich.proco.persistence.ChallengeDaoHibernate;

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
public class ShowUserStat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userName = user.getUserName();
        ChallengeDaoHibernate challengeHibernate = new ChallengeDaoHibernate();
        List<Challenge> challenges = challengeHibernate.getChallengesByUsername(userName);
        session.setAttribute("challenges", challenges);

        String url = "/user-stat.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
