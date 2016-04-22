package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;
import com.gorbich.proco.application.Search;
import com.gorbich.proco.entity.Question;
import com.gorbich.proco.persistence.QuestionDaoHibernate;

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
 * Show All Questions servlet.
 * Shows the list of all questions in the table.
 */
public class ShowAllQuestions extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = (request.getParameter("page") == null) ? 1 : Integer.parseInt(request.getParameter("page"));
        HttpSession session = request.getSession();
        session.setAttribute("page", pageNumber);

        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        Search search = proco.getSearchQuestionsResults(pageNumber);
        session.setAttribute("questions", search.getSearchResults());
        session.setAttribute("totalPages", search.getTotalNumberOfPages());
        session.setAttribute("beginPage", search.getBeginPage());
        session.setAttribute("endPage", search.getEndPage());

        String url = "/admin-allquestions.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}