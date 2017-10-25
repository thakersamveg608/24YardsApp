package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.api;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vrihas on 1/9/17.
 */

public interface RequestSortApi {
    @GET(Urls.SUB_URL_SORT)
    Call<SubCategoryList> getSort(@Query("sort_order") String sort_type,@Query("property_type") String property_type);
}
