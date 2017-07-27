package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.model.OtpData;

public interface OtpVerificationCallback {
void onOtpVerified(OtpData otpData);
    void onFailure(String error);
}
