package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.api;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchList;

import java.util.List;

import okhttp3.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vrihas on 25/8/17.
 */

public interface RequestSearchApi  {

    @GET(Urls.SUB_URL_SEARCH)
    retrofit2.Call<SearchList> getSearchData(@Query("property_type") String property_type, @Query("location") String location, @Query("min_price") String min_price, @Query("max_price") String max_price, @Query("bhk") List<String> bhk_list, @Field("usage") String usage_type);

}
