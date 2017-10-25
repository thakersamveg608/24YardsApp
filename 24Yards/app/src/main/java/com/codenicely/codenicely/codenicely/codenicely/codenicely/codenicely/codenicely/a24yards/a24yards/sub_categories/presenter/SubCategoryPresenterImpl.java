package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.presenter;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryList;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.provider.SubCategoryProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view.OnSubCategoryRecieved;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.view.SubCategoryView;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoryPresenterImpl implements SubCategoryPresenter{

    SubCategoryView subCategoryView;
    SubCategoryProvider subCategoryProvider;

    public SubCategoryPresenterImpl(SubCategoryView subCategoryView, SubCategoryProvider subCategoryProvider) {
        this.subCategoryView = subCategoryView;
        this.subCategoryProvider = subCategoryProvider;
    }
    @Override
    public void requestSubCategory(String property_type) {

        subCategoryView.showProgressBar(true);
        subCategoryProvider.requestSubCategoryData(property_type, new OnSubCategoryRecieved() {
            @Override
            public void onSuccess(SubCategoryList subCategoryList) {
                subCategoryView.showProgressBar(false);
                if(subCategoryList.isSuccess()){
                    subCategoryView.setSubCategoryData(subCategoryList.getGet_property());
                }
            }

            @Override
            public void onFailure() {
                subCategoryView.showProgressBar(false);
            }
        });

    }
}
