package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Question;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Hibernate to map Question entity.
 */
public class QuestionDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The method returns a list of all questions with pagination.
     * @param page
     * @param pageSize
     * @return list of qll questions
     */
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

    /**
     * The method returns total number of questions in database
     * @return number of questions
     */
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

    /**
     * The method updates tue question.
     * @param question
     */
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

    /**
     * The method deletes the question from database.
     * @param question
     */
    public void deleteQuestion(Question question) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(question);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    /**
     * The method adds new question to database.
     * @param question
     * @return question id
     */
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

    /**
     * The method returns a list of questions filtered by category and limit.
     * The order order of questions in the list is random.
     * @param category
     * @param limit
     * @return list of questions
     */
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

    /**
     * The method returns a question by its id.
     * @param questionId
     * @return question object
     */
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

    /**
     * The method returns a list of questions that contain the search term.
     * Pagination is provided.
     * @param column
     * @param searchTerm
     * @param page
     * @param pageSize
     * @return list of questions
     */
    public List getSearchQuestionsWithPagination(String column, String searchTerm, int page, int pageSize) {
        List<Question> questions = new ArrayList<Question>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.like(column, searchTerm, MatchMode.ANYWHERE).ignoreCase());
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

    /**
     * The method returns the total number of entries for a specific search term.
     * @param column
     * @param searchTerm
     * @return number of entries
     */
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