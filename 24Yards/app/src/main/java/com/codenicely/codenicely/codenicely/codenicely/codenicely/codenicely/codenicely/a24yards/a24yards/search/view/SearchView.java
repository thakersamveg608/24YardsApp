package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.view;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchData;

import java.util.List;

/**
 * Created by vrihas on 25/8/17.
 */

public interface SearchView {
    void showProgressBar(boolean show);
    void showSearchStatus(boolean status);
    void showError(String message);
    void setSearchData(List<SearchData> searchDataList);
}
