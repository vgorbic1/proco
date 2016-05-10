package com.gorbich.proco.persistence;

import com.gorbich.proco.entity.Challenge;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Tests for Challenge Dao
 */
public class ChallengeDaoHibernateTest extends TestCase {
    ChallengeDaoHibernate challengeHibernate;
    String userName;
    public final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception {
        challengeHibernate = new ChallengeDaoHibernate();
        userName = "testuser";
    }

    @Test
    public void testGetChallengesByUsername() throws Exception {
        // test user should have at least one test completed
        List<Challenge> challenges = challengeHibernate.getChallengesByUsername(userName);
        assertTrue(challenges.size() > 0);
    }

    @Test
    public void testAddChallenge() throws Exception {
        Challenge challenge = new Challenge();
        challenge.setUserName(userName);
        challengeHibernate.addChallenge(challenge);
        List<Challenge> challenges = challengeHibernate.getChallengesByUsername(userName);
        Challenge result = challenges.get(0);
        assertTrue(result.getUserName().equals(userName));
    }

    @Test
    public void testDeleteChallengeByUsername() throws Exception {
        challengeHibernate.deleteChallengeByUsername(userName);
        List<Challenge> challenges = challengeHibernate.getChallengesByUsername(userName);
        assertTrue(challenges.size() == 0);
    }

}