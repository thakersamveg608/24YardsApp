package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.model.LoginDataResponse;

public interface LoginCallback {

void onLoginSuccess(LoginDataResponse loginResponse);
    void onLoginFailure(String error);
}
