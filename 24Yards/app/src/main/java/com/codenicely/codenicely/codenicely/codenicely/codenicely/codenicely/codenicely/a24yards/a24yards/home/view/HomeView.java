package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model.CategoryData;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public interface HomeView {

    void setData(List<CategoryData> categoryDatas);
    void showProgressBar(boolean show);
    void showMessage(String message);

}
