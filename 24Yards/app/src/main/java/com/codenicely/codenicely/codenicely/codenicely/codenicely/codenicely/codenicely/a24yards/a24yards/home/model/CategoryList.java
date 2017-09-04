package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class CategoryList {

    private List<CategoryData> data;
    private boolean success;
    private String message;

    public List<CategoryData> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public CategoryList(List<CategoryData> data, boolean success, String message) {

        this.data = data;
        this.success = success;
        this.message = message;
    }
}
