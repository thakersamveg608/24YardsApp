package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.SearchCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.api.RequestSearchApi;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.search.model.SearchDataResponse;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vrihas on 25/8/17.
 */

public class RetrofitSearchProvider implements SearchProvider {

    private static String TAG ="RetrofitSearchProvider";

    @Override
    public void searchData(String property_type, String location, String min_price, String max_price, List<String> bhk_list, String usage_type, final SearchCallback searchCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestSearchApi requestSearchApi = retrofit.create(RequestSearchApi.class);
        Call<SearchDataResponse> call = requestSearchApi.getJson(property_type,location,min_price,max_price,bhk_list,usage_type);
        call.enqueue(new Callback<SearchDataResponse>() {
            @Override
            public void onResponse(Call<SearchDataResponse> call, Response<SearchDataResponse> response) {
                searchCallback.onSearchSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SearchDataResponse> call, Throwable t) {
                searchCallback.onSearchFailure(t.getMessage());
            }
        });

    }
}
