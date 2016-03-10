package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.persistence.QuestionDaoHibernate;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 3/8/2016.
 */
public class RequestQuestions extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
        List<Question> questions = questionHibernate.getAllQuestions();
        session.setAttribute("questions", questions);

        String url = "/displayAllQuestions.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
