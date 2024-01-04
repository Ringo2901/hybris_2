package org.training.core.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.dao.QuestionsDao;
import questions.model.QuestionModel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;


public class DefaultQuestionsDao implements QuestionsDao {
    private static final String SQL_DATE_FORMAT = "yyyy-MM-dd";

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<QuestionModel> getQuestionsAddedAfterDate(Date date) {
        final String theDay = new SimpleDateFormat(SQL_DATE_FORMAT).format(date);
        final String queryString = //
                "SELECT {p:" + QuestionModel.PK + "} "//
                        + "FROM {" + QuestionModel._TYPECODE + " AS p} " //
                        + "WHERE {CREATIONTIME} >= DATE \'" + theDay + "\' ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<QuestionModel>search(query).getResult();
    }

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}