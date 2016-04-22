package com.gorbich.proco.application;

import com.gorbich.proco.entity.Question;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 4/16/2016.
 */
public class Search {
    private List<Question> searchResults;
    private Long totalNumberOfQuestions;
    private int totalNumberOfPages;
    private int beginPage;
    private int endPage;
    private boolean success = false;

    public Search() {
        this.searchResults = new ArrayList<Question>();
    }

    public List<Question> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Question> searchResults) {
        this.searchResults = searchResults;
    }

    public Long getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

    public void setTotalNumberOfQuestions(Long totalNumberOfQuestions) {
        this.totalNumberOfQuestions = totalNumberOfQuestions;
    }

    public int getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
