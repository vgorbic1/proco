package com.gorbich.persistence;

import com.gorbich.entity.Question;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Vlad on 2/21/2016.
 */
public class QuestionDaoHibernate implements QuestionDao {
    private final Logger log = Logger.getLogger(this.getClass()); // Optional

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            questions = session.createCriteria(Question.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questions;
    }

    @Override
    public void updateQuestion(Question question) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(question);
            tx.commit();
            log.info("Question updated");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteQuestion(Question question) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(question);
            tx.commit();
            log.info("Question deleted");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public int addQuestion(Question question) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer questionId = null;
        try {
            tx = session.beginTransaction();
            questionId = (Integer) session.save(question);
            tx.commit();
            log.info("Added question: " + question + " with id of: " + questionId);
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questionId;
    }
}
