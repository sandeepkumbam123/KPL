package com.sandeep.kpl.ViewModels;

import android.databinding.BaseObservable;

import com.sandeep.kpl.Model.NavigationModelData;

public class NavigationViewModel extends BaseObservable {


    public String userName;

    public  NavigationViewModel(String userName) {
        this.userName = userName;
         new NavigationModelData(userName);
    }



    public void onViewClicked() {
      if (Utils.isOnline()) {
          // get information from the backend and save the page to database
      } else {
          // load the page from the backend into the main page ui directly
      }
    }


}
