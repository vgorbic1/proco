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
 * Created by Vlad on 3/13/2016.
 */
public class UpdateQuestion extends HttpServlet {
    //private final Logger log = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //log.info(session.getAttribute("editQuestion"));
        Question q = (Question) session.getAttribute("editQuestion");
        int questionId = q.getQuestionId();

        String category = request.getParameter("category");
        String level = request.getParameter("level");
        String inquiry = request.getParameter("question");
        String answer = request.getParameter("answer");
        boolean success = true;
        String resultMessage = "";



        if (inquiry == "" || inquiry == null) {
            resultMessage = "<p class=\"error\">Question was empty. The saved Question is used.</p>";
            success = false;
            session.setAttribute("answer", answer);
        }

        if (answer == "" || answer == null) {
            resultMessage += "<p class=\"error\">Answer was empty. The saved Answer is used.</p>";
            success = false;
            session.setAttribute("inquiry", inquiry);
        }

        if (success) {
            QuestionDaoHibernate questionHibernate = new QuestionDaoHibernate();
            Question question = new Question();
            question.setQuestionId(questionId);
            question.setCategory(category);
            question.setLevel(level);
            question.setInquiry(inquiry);
            question.setAnswer(answer);
            questionHibernate.updateQuestion(question);

            resultMessage = "<p class='success'>Question was successfully updated</p>";
        }

        session.setAttribute("message", resultMessage);
        session.setAttribute("success", success);

        String url = "update-question";
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
