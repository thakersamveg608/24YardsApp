package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchDataResponse;

/**
 * Created by vrihas on 25/8/17.
 */

public interface SearchCallback {

    void onSearchSuccess(SearchDataResponse searchDataResponse);
    void onSearchFailure(String error);
}
