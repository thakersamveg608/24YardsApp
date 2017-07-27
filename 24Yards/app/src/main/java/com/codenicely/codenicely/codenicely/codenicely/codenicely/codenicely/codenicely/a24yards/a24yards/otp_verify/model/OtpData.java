package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.model;



public class OtpData {
    private String message;
    private String access_token;
    private boolean success;
    public OtpData(String message, String access_token, boolean success)
    {
        this.message=message;
        this.success=success;

        this.access_token=access_token;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }



    public String getAccess_token() {
        return access_token;
    }
}
