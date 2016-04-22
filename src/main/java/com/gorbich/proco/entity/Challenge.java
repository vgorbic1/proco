package com.gorbich.proco.entity;

import java.util.Date;

/**
 * Created by Vlad on 3/25/2016.
 */
public class Challenge {
    private int challengeId;
    private String userName;
    private Date date;
    private String category;
    private int totalQuestions;
    private int correctQuestions;

    public Challenge() {
    }

    public Challenge(int challengeId, String userName, Date date, String category, int correctQuestions, int totalQuestions) {
        this.challengeId = challengeId;
        this.userName = userName;
        this.date = date;
        this.category = category;
        this.correctQuestions = correctQuestions;
        this.totalQuestions = totalQuestions;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }
}
