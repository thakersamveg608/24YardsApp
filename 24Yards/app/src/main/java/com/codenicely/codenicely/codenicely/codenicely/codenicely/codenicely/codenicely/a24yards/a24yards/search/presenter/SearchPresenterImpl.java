package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.presenter;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.SearchCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchData;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchList;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.provider.SearchProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.view.SearchView;

import java.util.List;

/**
 * Created by vrihas on 25/8/17.
 */

public class SearchPresenterImpl implements SearchPresenter{
    private SearchProvider searchProvider;
    private SearchView searchView;

    public SearchPresenterImpl(SearchProvider searchProvider, SearchView searchView) {
        this.searchProvider = searchProvider;
        this.searchView = searchView;
    }

    @Override
    public void requestSearchData(String property_type, String location, String min_price, String max_price, List<String> bhk_list, String usage_type) {
        searchView.showProgressBar(true);
        searchProvider.searchData(property_type, location, min_price, max_price, bhk_list, usage_type, new SearchCallback() {
            @Override
            public void onSearchSuccess(SearchList searchList) {
                searchView.showProgressBar(false);
                if (searchList.isSuccess()){
                    searchView.setSearchData(searchList.getGet_search());
                }
            }

            @Override
            public void onSearchFailure(String error) {

            }
        });

    }

//    @Override
//    public void getSearchData(String property_type, String location, String min_price, String max_price, List<String> bhk_list, String usage_type) {
//        searchView.showProgressBar(true);
//        searchProvider.searchData(property_type, location, min_price, max_price,  bhk_list, usage_type, new SearchCallback() {
//            @Override
//            public void onSearchSuccess(SearchList searchList) {
//                searchView.showProgressBar(false);
//                if (searchList.isSuccess()){
//                    searchView.showSearchStatus(true);
//                    searchView.setSearchData(searchList.getGet_search());
//                }
//            }
//
//            @Override
//            public void onSearchFailure(String error) {
//                   searchView.showError("Something went wrong!! check your internet connection");
//                   searchView.showProgressBar(false);
//                   searchView.showSearchStatus(false);
//            }
//        });
//    }


}
