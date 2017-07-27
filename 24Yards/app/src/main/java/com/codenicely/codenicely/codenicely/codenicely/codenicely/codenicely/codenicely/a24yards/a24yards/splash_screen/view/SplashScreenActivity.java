package com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.splash_screen.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.HomeActivity;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.helper.SharedPrefs;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.login.view.LoginActivity;
import com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.welcome.view.WelcomeActivity;


import butterknife.BindView;
import butterknife.ButterKnife;

import static com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R.id.ll;
import static com.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.codenicely.a24yards.a24yards.R.id.yards24_logo;

/**
 * Created by samveg on 22/7/17.
 */

public class SplashScreenActivity extends Activity {

    private Handler handler;
    private SharedPrefs sharedPrefs;

    @BindView(R.id.codeNicelyLogo)
    ImageView code_nicely_logo;

    @BindView(yards24_logo)
    ImageView yards_24_logo;

    @BindView(ll)
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);



        Glide.with(this).load(R.drawable.codenicely_coloured_logo_min).into(code_nicely_logo);
        Glide.with(this).load(R.drawable.app_logo).into(yards_24_logo);

        linearLayout.setBackgroundResource(R.drawable.bg);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (sharedPrefs.isLoggedIn()) {
                    startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
                    finish();
                }

            }
        }, 2500);


    }

}