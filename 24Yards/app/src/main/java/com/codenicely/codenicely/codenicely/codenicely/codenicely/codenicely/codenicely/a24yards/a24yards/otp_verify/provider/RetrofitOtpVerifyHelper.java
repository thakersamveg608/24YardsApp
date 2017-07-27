package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.provider;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Urls;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.OtpVerificationCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.api.RequestOtpVerify;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.model.OtpData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitOtpVerifyHelper implements OtpVerifyHelperClass {
    private static String TAG = "RetrofitOtpVerifyHelper";
    private Call<OtpData> call;

    @Override
    public void getOtpResponse(final String otp, String mobile,final OtpVerificationCallback otpVerificationCallback) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).build();
        final RequestOtpVerify requestOtpVerify = retrofit.create(RequestOtpVerify.class);

         call = requestOtpVerify.getJson(otp, mobile);
        call.enqueue(new Callback<OtpData>() {
            @Override
            public void onResponse(Call<OtpData> call, Response<OtpData> response) {

                otpVerificationCallback.onOtpVerified(response.body());

            }

            @Override
            public void onFailure(Call<OtpData> call, Throwable t) {
                t.printStackTrace();
                otpVerificationCallback.onFailure(t.getMessage());
            }
        });

    }

    @Override
    public void onDestroy() {
        if(call!=null){
            call.cancel();
        }

    }
}
