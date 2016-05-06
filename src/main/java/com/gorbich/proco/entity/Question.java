package com.gorbich.proco.entity;

/**
 * Question bean.
 * The class represents questions in database.
 */
public class Question {
    private int questionId;
    private String category;
    private String level;
    private String inquiry;
    private String answer;

    /**
     * Empty Constructor
     */
    public Question() {
    }

    /**
     * Constructor to load all properties
     * @param questionId
     * @param category
     * @param level
     * @param inquiry
     * @param answer
     */
    public Question(int questionId, String category, String level, String inquiry, String answer) {
        this.questionId = questionId;
        this.category = category;
        this.level = level;
        this.inquiry = inquiry;
        this.answer = answer;
    }

    /**
     * Getter for Question ID
     * @return questionId
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Setter for Question ID
     * @param questionId
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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
     * Getter for Level
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Setter for Level
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Getter for Inquiry
     * @return inquiry
     */
    public String getInquiry() {
        return inquiry;
    }

    /**
     * Setter for Inquiry
     * @param inquiry
     */
    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    /**
     * Getter for Answer
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Setter for Answer
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
