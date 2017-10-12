package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.model;

/**
 * Created by vrihas on 1/9/17.
 */

public class SortDataResponse {
    private boolean success;
    private String message;

    public SortDataResponse(boolean success, String message) {
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
