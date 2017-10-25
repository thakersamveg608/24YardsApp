package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.view;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryData;

import java.util.List;

/**
 * Created by vrihas on 1/9/17.
 */

public interface SortView {
    void showProgressBar(boolean show);
    void showSortStatus(boolean status);
    void showError(String message);
    void setSubCategoryData(List<SubCategoryData> subCategoryList);
}
