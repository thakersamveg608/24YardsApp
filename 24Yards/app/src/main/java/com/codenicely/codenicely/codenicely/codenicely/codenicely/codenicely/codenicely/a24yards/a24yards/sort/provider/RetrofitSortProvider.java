package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.SortCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sort.api.RequestSortApi;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.sub_categories.model.SubCategoryList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vrihas on 1/9/17.
 */

public class RetrofitSortProvider implements SortProvider{

    private static String TAG ="RetrofitSortProvider";


    @Override
    public void sortData(String sort_type, String property_type,final SortCallback sortCallback) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestSortApi requestSortApi = retrofit.create(RequestSortApi.class);
        Call<SubCategoryList> call = requestSortApi.getSort(sort_type,property_type);
        call.enqueue(new Callback<SubCategoryList>() {
            @Override
            public void onResponse(Call<SubCategoryList> call, Response<SubCategoryList> response) {
                sortCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubCategoryList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
