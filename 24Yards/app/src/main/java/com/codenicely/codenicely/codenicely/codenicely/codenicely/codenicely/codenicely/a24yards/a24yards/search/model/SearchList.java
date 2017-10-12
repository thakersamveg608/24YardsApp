package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model;

import java.util.List;

/**
 * Created by vrihas on 25/8/17.
 */

public class SearchList {
    private boolean success;
    private String message;
    private List<SearchData> get_search;

    public SearchList(boolean success, String message, List<SearchData> get_search) {
        this.success = success;
        this.message = message;
        this.get_search = get_search;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<SearchData> getGet_search() {
        return get_search;
    }
}
