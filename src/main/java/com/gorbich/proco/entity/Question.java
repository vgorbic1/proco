package com.gorbich.proco.entity;

/**
 * Created by Vlad on 2/21/2016.
 */
public class Question {
    private int questionId;
    private String category;
    private String level;
    private String inquiry;
    private String answer;

    public Question() {
    }

    public Question(int questionId, String category, String level, String inquiry, String answer) {
        this.questionId = questionId;
        this.category = category;
        this.level = level;
        this.inquiry = inquiry;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                ", inquiry='" + inquiry + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
