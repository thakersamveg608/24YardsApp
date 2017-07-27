package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.HomeActivity;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.Keys;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.SharedPrefs;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.model.OtpData;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.presenter.OtpVerifyPresenter;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.presenter.OtpVerifyPresenterImp;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.otp_verify.provider.RetrofitOtpVerifyHelper;

import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity implements OtpView {
    private Button button;
    private EditText editTextOtp;
    private ProgressBar progressBar;
    private String message, otp_number;
    private OtpVerifyPresenter otpVerifyPresenter;
    private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            message = bundle.getString(Keys.KEY_MOBILE);
        }
        sharedPrefs = new SharedPrefs(this);
        editTextOtp = (EditText) findViewById(R.id.input_otp);
        button = (Button) findViewById(R.id.otpIn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    public void proceed_verify(View v) {
        otp_number = editTextOtp.getText().toString();
        otpVerifyPresenter = new OtpVerifyPresenterImp(this, new RetrofitOtpVerifyHelper());
        otpVerifyPresenter.otpData(otp_number, message);
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OtpStatus(OtpData otpData) {

        Intent i = new Intent(this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        sharedPrefs.setAccessToken(otpData.getAccess_token());
        sharedPrefs.setLogin(true);
        finish();


    }

    @Override
    protected void onDestroy() {
        if(otpVerifyPresenter!=null){
            otpVerifyPresenter.onDestroy();
        }
        super.onDestroy();

    }
}
