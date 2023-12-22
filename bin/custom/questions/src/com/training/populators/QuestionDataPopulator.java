package com.training.populators;

import questions.data.QuestionData;
import de.hybris.platform.converters.Populator;
import questions.model.QuestionModel;

public class QuestionDataPopulator implements Populator<QuestionModel, QuestionData> {
    @Override
    public void populate(final QuestionModel source, final QuestionData target) {
        target.setQuestion(source.getQuestion());
        target.setQuestionCustomer(source.getQuestionCustomer().getOriginalUid());
        if (source.getAnswer() != null) {
            target.setAnswer(source.getAnswer());
        }
        if (source.getAnswerCustomer() != null) {
            target.setAnswerCustomer(source.getAnswerCustomer().getOriginalUid());
        }
    }
}