package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Challenge;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vlad on 3/25/2016.
 */
public class ChallengeDaoHibernate {
    private final Logger log = Logger.getLogger(this.getClass());

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

    public List<Challenge> getAllChallenges() {
        List<Challenge> challenges = new ArrayList<Challenge>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Challenge.class);
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

    public int addChallenge(Challenge challenge) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer challengeId = null;
        try {
            tx = session.beginTransaction();
            challenge.setDate(new Date());
            challengeId = (Integer) session.save(challenge);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return challengeId;
    }

}
