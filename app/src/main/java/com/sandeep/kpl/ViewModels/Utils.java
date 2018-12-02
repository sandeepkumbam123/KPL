package com.sandeep.kpl.ViewModels;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sandeep.kpl.KPLApplication;

public class Utils {


    public static boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) (KPLApplication.getContext()).getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }



    public static String[] listofNavigationItems() {
        return new String[]{"Library","SchoolData", "College","SI","D.S.C."};
    }
}
