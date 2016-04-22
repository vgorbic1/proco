package com.gorbich.proco.persistence;

import com.gorbich.proco.application.Search;
import com.gorbich.proco.entity.Question;
import org.apache.log4j.Logger;
import org.apache.log4j.rewrite.ReflectionRewritePolicy;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Vlad on 2/21/2016.
 */
public class QuestionDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<Question>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            questions = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questions;
    }

    public List<Question> getAllQuestionsWithPagination(int page, int pageSize) {
        List<Question> questions = new ArrayList<Question>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.setFirstResult((page - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            questions = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questions;
    }

    public Long getTotalNumberOfQuestions() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Long totalQuestions = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.setProjection(Projections.rowCount());
            totalQuestions = (Long) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return totalQuestions;
    }

    public void updateQuestion(Question question) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(question);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    public void deleteQuestion(int questionId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.eq("questionId", questionId));
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    public int addQuestion(Question question) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer questionId = null;
        try {
            tx = session.beginTransaction();
            questionId = (Integer) session.save(question);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questionId;
    }

    public List<Question> getSpecificCategoryRandomQuestionsWithLimit(String category, int limit) {
        List<Question> questions = new ArrayList<Question>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.eq("category", category));
            criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
            criteria.setMaxResults(limit);
            questions = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questions;
    }

    public Question getQuestionById(int questionId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Question question = new Question();
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.eq("questionId", questionId));
            question = (Question) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return question;
    }

    public List getSearchQuestionsWithPagination(String column, String searchTerm, int page, int pageSize) {
        List<Question> questions = new ArrayList<Question>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.like(column, searchTerm, MatchMode.ANYWHERE).ignoreCase());
            //criteria.setProjection(Projections.rowCount());
            //totalQuestions = (Long) criteria.uniqueResult();
            //search.setTotalNumberOfQuestions(totalQuestions);
            criteria.setFirstResult((page - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            questions = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return questions;
    }

    public Long getSearchTotalNumberOfEntries(String column, String searchTerm) {
        Long totalQuestions = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.like(column, searchTerm, MatchMode.ANYWHERE).ignoreCase());
            criteria.setProjection(Projections.rowCount());
            totalQuestions = (Long) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return totalQuestions;
    }

}