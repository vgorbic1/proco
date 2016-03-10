package com.gorbich.proco.servlet;

import com.gorbich.proco.entity.Question;
import com.gorbich.proco.persistence.QuestionDaoHibernate;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Vlad on 3/9/2016.
 */
public class CreateQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String category = request.getParameter("category");
        String level = request.getParameter("level");
        String inquiry = request.getParameter("question");
        String answer = request.getParameter("answer");
        boolean success = true;
        String resultMessage = "";

        HttpSession session = request.getSession();

        if (inquiry == "" || inquiry == null) {
            resultMessage = "<p class=\"error\">Question is empty.</p>";
            success = false;
            session.setAttribute("answer", answer);
        }

        if (answer == "" || answer == null) {
            resultMessage += "<p class=\"error\">Answer is empty.</p>";
            success = false;
            session.setAttribute("inquiry", inquiry);
        }

        if (success) {
            QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
            int insertedQuestionId;

            Question question = new Question();
            question.setCategory(category);
            question.setLevel(level);
            question.setInquiry(inquiry);
            question.setAnswer(answer);
            insertedQuestionId = questionHibernate.addQuestion(question);

            if (insertedQuestionId == 0) {
                resultMessage = "<p class='error'>Failed to add the Question</p>";
            } else {
                resultMessage = "<p class='success'>Question was successfully added</p>";
            }
        }

        session.setAttribute("message", resultMessage);

        String url = "question-add";
        response.sendRedirect(url);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
