package com.gorbich.proco.entity;

import java.util.Date;

/**
 * Challenge Bean.
 * The class represents Test Statistics.
 */
public class Challenge {
    private int challengeId;
    private String userName;
    private Date date;
    private String category;
    private int totalQuestions;
    private int correctQuestions;

    /**
     * Empty Constructor
     */
    public Challenge() {
    }

    /**
     * Constructor to load all properties
     * @param challengeId
     * @param userName
     * @param date
     * @param category
     * @param correctQuestions
     * @param totalQuestions
     */
    public Challenge(int challengeId,
                     String userName,
                     Date date, String category,
                     int correctQuestions,
                     int totalQuestions) {
        this.challengeId = challengeId;
        this.userName = userName;
        this.date = date;
        this.category = category;
        this.correctQuestions = correctQuestions;
        this.totalQuestions = totalQuestions;
    }

    /**
     * Getter for Challenge ID
     * @return challengeId
     */
    public int getChallengeId() {
        return challengeId;
    }

    /**
     * Setter for Challenge ID
     * @param challengeId
     */
    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    /**
     * Getter for User Name
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for User Name
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for Date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for Date
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for Category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for Category
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for Total Number of Questions
     * @return totalQuestions
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * Setter for Total Number of Questions
     * @param totalQuestions
     */
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    /**
     * Getter for Number of Correct Questions
     * @return correctQuestions
     */
    public int getCorrectQuestions() {
        return correctQuestions;
    }

    /**
     * Setter for number of Correct Questions
     * @param correctQuestions
     */
    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }
}
