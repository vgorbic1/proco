package com.gorbich.proco.controller;

import com.gorbich.proco.application.Proco;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Delete User controller.
 * Displays page that allows to delete a user.
 */
public class DeleteUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        ServletContext context = getServletContext();
        Proco proco = (Proco)context.getAttribute("proco");
        proco.deleteUserChallenge(userId);
        proco.deleteUser(userId);
        response.sendRedirect("user-deleted");
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
