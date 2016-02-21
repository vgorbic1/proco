package com.gorbich.entity;

/**
 * Created by Vlad on 2/21/2016.
 */
public class Question {
    private int questionId;
    private String questionBody;
    private String answer;
    private String image;
    private String level;

    public Question() {
    }

    public Question(int questionId, String questionBody, String answer, String image, String level) {
        this.questionId = questionId;
        this.questionBody = questionBody;
        this.answer = answer;
        this.image = image;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionBody='" + questionBody + '\'' +
                ", answer='" + answer + '\'' +
                ", image='" + image + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
