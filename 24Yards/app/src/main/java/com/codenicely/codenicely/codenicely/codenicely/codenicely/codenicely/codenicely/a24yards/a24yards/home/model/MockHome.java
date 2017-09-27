package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.provider.CategoryProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view.OnCategoryRecieved;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrihas on 26/9/17.
 */

public class MockHome implements CategoryProvider {
    @Override
    public void requestCategory(OnCategoryRecieved onCategoryRecieved) {
        List<CategoryData> dataList = new ArrayList<>();
        CategoryData data = new CategoryData("Projects for Sale","https://static.domain.com.au/domainblog/uploads/2017/03/09042013/2_gpzctv.jpg");
        dataList.add(data);
        data = new CategoryData("Projects for Rent","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwjT_NkrBxAgaybCfJz2U0P_PF27KKzYPpG7SKIBYyFXGBN4Vo_w");
        dataList.add(data);
        data = new CategoryData("Featured Projects","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfGiTPK_A5Fm5gNfzR39_R3GDhX3z_Y-07ndithL1nc6-IzsAV");
        dataList.add(data);
        CategoryList categoryList = new CategoryList(dataList,true,"Check your Internet Connection..!!");
        onCategoryRecieved.onSuccess(categoryList);
    }
}
