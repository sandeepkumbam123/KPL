package com.sandeep.kpl.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public static final int SPLASH_TIME = 3000;


    public void navigateToNextActivity(Context src , Class destination) {
        startActivity(new Intent(src,destination));
    }
}
