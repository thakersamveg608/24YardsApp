package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.provider.SubCategoryProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view.OnSubCategoryRecieved;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 26/9/17.
 */

public class MockSubCategory implements SubCategoryProvider {
//    @Override
//    public void requestSubCategoryData(String property_type, OnSubCategoryRecieved onSubCategoryRecieved) {
//        List<SubCategoryData> dataList = new ArrayList<>();
//        SubCategoryData data = new SubCategoryData("Singhania Buildcon","Singapore City","1.5 crores","https://newprojects.99acres.com/projects/singhania_merlin_estate/singapore_city/images/scbrochure3.jpg");
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        dataList.add(data);
//        SubCategoryList subCategoryList = new SubCategoryList(true,"Check your Internet Connection..!!",dataList);
//        onSubCategoryRecieved.onSuccess(subCategoryList);
//    }

    @Override
    public void requestSubCategoryData(String property_type, String sort_type, String location, String min_price, String max_price, List<String> bhk_list, String usage_type, OnSubCategoryRecieved onSubCategoryRecieved) {
        List<SubCategoryData> dataList = new ArrayList<>();
        SubCategoryData data = new SubCategoryData("Singhania Buildcon","Singapore City","1.5 crores","https://newprojects.99acres.com/projects/singhania_merlin_estate/singapore_city/images/scbrochure3.jpg");
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        dataList.add(data);
        SubCategoryList subCategoryList = new SubCategoryList(true,"Check your Internet Connection..!!",dataList);
        onSubCategoryRecieved.onSuccess(subCategoryList);
    }
}
