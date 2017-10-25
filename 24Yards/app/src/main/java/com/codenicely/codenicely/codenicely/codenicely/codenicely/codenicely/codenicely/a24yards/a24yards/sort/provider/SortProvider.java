package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.SortCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryList;

/**
 * Created by vrihas on 1/9/17.
 */

public interface SortProvider {
    void sortData(String sort_type, String property_type, SortCallback sortCallback);
}
