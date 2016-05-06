package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Challenge;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import java.util.Date;
import java.util.List;

/**
 * DAO to map Challenge entity.
 */
public class ChallengeDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The method gets Challenges for a particular user name.
     * @param userName
     * @return list of Challenges
     */
    public List<Challenge> getChallengesByUsername(String userName) {
        Session session = getSession();
        List<Challenge> challenges;
        Criteria criteria = session.createCriteria(Challenge.class);
        criteria.add(Restrictions.eq("userName", userName));
        challenges = criteria.list();
        session.close();
        return challenges;
    }

    /**
     * The method adds new Challenge to database.
     * @param challenge
     */
    public void addChallenge(Challenge challenge) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            challenge.setDate(new Date());
            session.save(challenge);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    /**
     * The Method delete all user's tests (Challenges).
     * @param userName
     */
    public void deleteChallengeByUsername(String userName) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String query = "delete Challenge where userName = :userName";
            session.createQuery(query).setParameter("userName", userName).executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    /**
     * Utility method to create Hibernate session.
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
