package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view.OnSubCategoryRecieved;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubCategoryProvider {

    void requestSubCategoryData(String property_type, String sort_type, String location, String min_price, String max_price, List<String> bhk_list, String usage_type,OnSubCategoryRecieved onSubCategoryRecieved);

}
