package com.gorbich.proco.entity;

/**
 * Result bean
 * Class represents Results in database.
 */
public class Result {
    private int questionNumber;
    private String level;
    private String inquiry;
    private String answer;
    private String result;

    /**
     * Empty Constructor
     */
    public Result() {
    }

    /**
     * Constructor to load properties
     * @param questionNumber
     * @param level
     * @param inquiry
     * @param answer
     * @param result
     */
    public Result(int questionNumber, String level, String inquiry, String answer, String result) {
        this.questionNumber = questionNumber;
        this.level = level;
        this.inquiry = inquiry;
        this.answer = answer;
        this.result = result;
    }

    /**
     * Getter for Question Number
     * @return questionNumber
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    /**
     * Setter for Question Number
     * @param questionNumber
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
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

    /**
     * Getter for Result
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * Setter for Result
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}
