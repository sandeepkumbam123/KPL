package com.sandeep.kpl.Views;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sandeep.kpl.R;

public class SplashScreenActivity extends BaseActivity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        mRunnable = new Runnable() {
            @Override
            public void run() {
                navigateToNextActivity(SplashScreenActivity.this,NavigationActivity.class);
            }
        };

        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, SPLASH_TIME);
    }
}
