package com.gorbich.proco.servlet;

import com.gorbich.proco.application.Proco;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Add Book Result servlet.
 * Gets user's input, checks whether it is empty or not.
 * Adds the book to the list of all books.
 * Notifies the user on result.
 */
public class AddBookResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        String isbn = request.getParameter("isbn");
        HttpSession session = request.getSession();

        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        String resultMessage = proco.addBook(category, isbn);

        session.setAttribute("message", resultMessage);
        response.sendRedirect("book-add");
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
