package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.presenter;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model.CategoryList;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.provider.CategoryProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view.HomeView;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view.OnCategoryRecieved;

/**
 * Created by samveg on 25/8/17.
 */

public class CategoryPresenterImpl implements CategoryPresenter{

    HomeView homeView;
    CategoryProvider categoryProvider;

    public CategoryPresenterImpl(HomeView homeView, CategoryProvider categoryProvider) {
        this.homeView = homeView;
        this.categoryProvider = categoryProvider;
    }

    @Override
    public void requesCategory() {

        homeView.showProgressBar(true);
        categoryProvider.requestCategory(new OnCategoryRecieved() {
            @Override
            public void onSuccess(CategoryList categoryList) {
                homeView.showProgressBar(false);
                if(categoryList.isSuccess()){
                    homeView.setData(categoryList.getData());
                }
                else{
                    homeView.showMessage(categoryList.getMessage());
                }

            }

            @Override
            public void onFailure() {
                homeView.showProgressBar(false);
                homeView.showMessage("We cant connect to our server.Please check your internet connection.");
            }
        });

    }
}
