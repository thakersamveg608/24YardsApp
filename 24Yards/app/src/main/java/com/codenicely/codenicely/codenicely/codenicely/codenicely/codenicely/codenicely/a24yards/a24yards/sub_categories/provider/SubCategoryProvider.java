package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view.OnSubCategoryRecieved;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubCategoryProvider {

    void requestSubCategoryData(String property_type,OnSubCategoryRecieved onSubCategoryRecieved);

}
