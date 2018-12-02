package com.sandeep.kpl;

import android.app.Application;

public class KPLApplication extends Application {

    private static Application myContext;

    @Override
    public void onCreate() {
        super.onCreate();
        myContext = this;
    }

    public static Application getContext() {
        return myContext;
    }
}
