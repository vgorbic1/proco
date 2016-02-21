package com.gorbich.persistence;

import com.gorbich.entity.Question;
import java.util.List;

/**
 * Created by Vlad on 2/21/2016.
 */
public interface QuestionDao {
    public List<Question> getAllQuestions();
    public void updateQuestion(Question question);
    public void deleteQuestion(Question question);
    public int addQuestion(Question question);
}
