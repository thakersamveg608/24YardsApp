package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.api;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchDataResponse;

import java.util.List;

import okhttp3.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by vrihas on 25/8/17.
 */

public interface RequestSearchApi  {
    @FormUrlEncoded
    @POST(Urls.SUB_URL_SEARCH)
    retrofit2.Call<SearchDataResponse> getJson(@Field("property_type") String property_type, @Field("location") String location, @Field("min_price") String min_price, @Field("max_price") String max_price, @Field("bhk") List<String> bhk_list, @Field("usage") String usage_type);

}
