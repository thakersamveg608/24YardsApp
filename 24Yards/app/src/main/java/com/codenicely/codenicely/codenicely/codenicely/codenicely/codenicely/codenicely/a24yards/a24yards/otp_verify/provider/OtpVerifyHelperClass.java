package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.provider;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.OtpVerificationCallback;

public interface OtpVerifyHelperClass {

    void getOtpResponse(String otp, String mobile, OtpVerificationCallback otpVerificationCallback);
    void onDestroy();
}
