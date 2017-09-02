package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoryList {

    boolean success;
    String message;
    private List<SubCategoryData> get_property;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<SubCategoryData> getGet_property() {
        return get_property;
    }

    public SubCategoryList(boolean success, String message, List<SubCategoryData> get_property) {

        this.success = success;
        this.message = message;
        this.get_property = get_property;
    }
}
