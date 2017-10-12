package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.model.SortDataResponse;

/**
 * Created by vrihas on 1/9/17.
 */

public interface SortCallback {
    void onSortSuccess(SortDataResponse sortDataResponse);
    void onSortFailure(String error);
}
