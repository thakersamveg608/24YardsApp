package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.api;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryData;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 26/8/17.
 */

public interface RequestSubCategoryApi {

    @GET(Urls.REQUEST_SUB_CATEGORY)
    Call<SubCategoryList> getsubCategoryData(@Query("property_type") String PropertyCategory,@Query("sort_order") String sort_type, @Query("location") String location, @Query("min_price") String min_price, @Query("max_price") String max_price, @Query("bhk") List<String> bhk_list, @Query("usage") String usage_type);

}
