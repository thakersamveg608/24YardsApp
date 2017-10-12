package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.presenter;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.SortCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.model.SortDataResponse;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.provider.SortProvider;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.view.SortView;

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
    public void getSortData(String sort_type) {
        sortView.showProgressBar(true);
        sortProvider.sortData(sort_type, new SortCallback() {
            @Override
            public void onSortSuccess(SortDataResponse sortDataResponse) {
                sortView.showProgressBar(false);
                sortView.showSortStatus(true);
            }

            @Override
            public void onSortFailure(String error) {
                sortView.showError("Something went wrong!! check your internet connection");
                sortView.showProgressBar(false);
                sortView.showSortStatus(false);
            }
        });
    }
}
