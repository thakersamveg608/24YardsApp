package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.provider;

import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.api.RequestCategoryApi;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.model.CategoryList;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.home.view.OnCategoryRecieved;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 24/8/17.
 */

public class RetrofitCategoryProvider implements CategoryProvider{
    @Override
    public void requestCategory(final OnCategoryRecieved onCategoryRecieved) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestCategoryApi request = retrofit.create(RequestCategoryApi.class);
        Call<CategoryList> call=request.getCategoryData();
        call.enqueue(new Callback<CategoryList>(){
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {

                onCategoryRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable throwable) {
                onCategoryRecieved.onFailure();
            }
        });

    }
}
