package org.training.core.dao;

import questions.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionsDao {
    List<QuestionModel> getQuestionsAddedAfterDate(Date date);
}
