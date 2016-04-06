package com.dtcj.liukai.notificationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Author: liuk
 * Created at: 16/3/31
 */
public class SplashActivity extends AppCompatActivity {

    public static final int DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                if(getIntent().getBundleExtra(Constants.EXTRA_BUNDLE) != null){
                    intent.putExtra(Constants.EXTRA_BUNDLE,
                            getIntent().getBundleExtra(Constants.EXTRA_BUNDLE));
                }
                startActivity(intent);
                finish();
            }
        }, DELAY_MILLIS);

    }
}
