package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Challenge;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO Hibernate to map Challenge entity.
 */
public class ChallengeDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * The method gets Challenges for a particular user name.
     * @param userName
     * @return list of Challenges
     */
    public List<Challenge> getChallengesByUsername(String userName) {
        List<Challenge> challenges = new ArrayList<Challenge>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Challenge.class);
            criteria.add(Restrictions.eq("userName", userName));
            challenges = criteria.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return challenges;
    }

    /**
     * The method adds new Challenge to database.
     * @param challenge
     */
    public void addChallenge(Challenge challenge) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
}
