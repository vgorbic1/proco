package com.gorbich.proco.persistence;

import junit.framework.TestCase;

/**
 * Created by Vlad on 5/6/2016.
 */
public class ChallengeDaoHibernateTest extends TestCase {
    public void testGetChallengesByUsername() throws Exception {

    }

    public void testAddChallenge() throws Exception {

    }

    public void testDeleteChallengeByUsername() throws Exception {
        ChallengeDaoHibernate challengeHibernate = new ChallengeDaoHibernate();
        challengeHibernate.deleteChallengeByUsername("123456");
    }

}