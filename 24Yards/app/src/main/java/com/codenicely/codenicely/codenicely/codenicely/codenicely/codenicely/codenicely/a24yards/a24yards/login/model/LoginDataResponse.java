package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.model;



public class LoginDataResponse {
    private boolean success;
    private String message;
    public LoginDataResponse(boolean success, String message)
    {
        this.message=message;
        this.success=success;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
