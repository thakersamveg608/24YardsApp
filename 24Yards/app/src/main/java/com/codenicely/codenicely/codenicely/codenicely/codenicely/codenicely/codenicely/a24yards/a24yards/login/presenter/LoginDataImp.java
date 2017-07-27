package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.presenter;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.LoginCallback;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.model.LoginDataResponse;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.provider.LoginBaseClassHelper;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.view.LoginView;

public class LoginDataImp implements LoginData {
    private LoginBaseClassHelper loginBaseClassHelper;
    private LoginView login;

    public LoginDataImp(LoginView login, LoginBaseClassHelper loginBaseClassHelper) {
        this.login = login;
        this.loginBaseClassHelper = loginBaseClassHelper;
    }


    @Override
    public void getLoginData(String mobile) {
        login.showProgressBar(true);
        loginBaseClassHelper.loginData(mobile,new LoginCallback() {
            @Override
            public void onLoginSuccess(LoginDataResponse loginResponse) {
                if(loginResponse.isSuccess()) {
                    login.showProgressBar(false);
                    login.showLoginStatus(true);
                }
            }

            @Override
            public void onLoginFailure(String error) {
                login.showError("Sorry!!Something went wrong");
                login.showLoginStatus(false);
                login.showProgressBar(false);
            }
        });
    }
}
