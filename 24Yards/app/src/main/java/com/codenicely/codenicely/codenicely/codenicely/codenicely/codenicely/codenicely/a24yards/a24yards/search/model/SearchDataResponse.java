package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model;

/**
 * Created by vrihas on 25/8/17.
 */

public class SearchDataResponse {
    private boolean success;
    private String message;

    public SearchDataResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
