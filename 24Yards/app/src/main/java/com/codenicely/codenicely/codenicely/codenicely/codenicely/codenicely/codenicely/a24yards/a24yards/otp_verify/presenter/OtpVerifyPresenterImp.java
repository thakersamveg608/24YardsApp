package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.presenter;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.OtpVerificationCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.model.OtpData;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.provider.OtpVerifyHelperClass;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.view.OtpView;

public class OtpVerifyPresenterImp implements OtpVerifyPresenter {
    private OtpView otpView;
    private OtpVerifyHelperClass otpVerifyHelperClass;

    public OtpVerifyPresenterImp(OtpView otpView, OtpVerifyHelperClass otpVerifyHelperClass) {
        this.otpView = otpView;
        this.otpVerifyHelperClass = otpVerifyHelperClass;
    }

    @Override
    public void otpData(final String otp, String mobile) {
        otpView.showProgressBar(true);
        otpVerifyHelperClass.getOtpResponse(otp, mobile,new OtpVerificationCallback() {
            @Override
            public void onOtpVerified(OtpData otpData) {

                if (otpData.isSuccess()) {
                    otpView.OtpStatus(otpData);

                } else {
                    otpView.showMessage(otpData.getMessage());
                }
                otpView.showProgressBar(false);
            }

            @Override
            public void onFailure(String error) {
                otpView.showProgressBar(false);
                otpView.showMessage("Sorry!!Something went wrong");
            }
        });

    }

    @Override
    public void onDestroy() {
        if(otpVerifyHelperClass!=null){
            otpVerifyHelperClass.onDestroy();
        }
    }
}
