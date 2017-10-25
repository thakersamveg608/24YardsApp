package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.presenter;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.SortCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.provider.SortProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.view.SortView;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryList;

/**
 * Created by vrihas on 1/9/17.
 */

public class SortPresenterImpl implements SortPresenter{

    private SortProvider sortProvider;
    private SortView sortView;

    public SortPresenterImpl(SortProvider sortProvider, SortView sortView) {
        this.sortProvider = sortProvider;
        this.sortView = sortView;
    }

    @Override
    public void getSortData(String sort_type,String property_type) {
        sortView.showProgressBar(true);
        sortProvider.sortData(sort_type, property_type, new SortCallback() {
            @Override
            public void onSuccess(SubCategoryList subCategoryList) {
                sortView.showProgressBar(false);
                if (subCategoryList.isSuccess()){
                    sortView.setSubCategoryData(subCategoryList.getGet_property());
                }
            }

            @Override
            public void onFaiure() {

            }
        });
    }
}
