package com.gorbich.proco.entity;

/**
 * Result bean
 * Class represents results.
 */
public class Result {
    private int questionNumber;
    private String level;
    private String inquiry;
    private String answer;
    private String result;

    public Result() {
    }

    public Result(int questionNumber, String level, String inquiry, String answer, String result) {
        this.questionNumber = questionNumber;
        this.level = level;
        this.inquiry = inquiry;
        this.answer = answer;
        this.result = result;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
