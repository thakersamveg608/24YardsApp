package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.view;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.model.OtpData;

public interface OtpView {
    void showProgressBar(boolean show);
    void showMessage(String message);
    void OtpStatus(OtpData otpData);
}
