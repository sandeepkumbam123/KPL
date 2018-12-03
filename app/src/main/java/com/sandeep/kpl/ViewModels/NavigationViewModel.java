package com.sandeep.kpl.ViewModels;

import android.databinding.BaseObservable;

import com.sandeep.kpl.Model.NavigationModelData;

public class NavigationViewModel extends BaseObservable {


    public String userName;
    private itemClick listener;

    public  NavigationViewModel(String userName ,itemClick listener) {
        this.userName = userName;
        this.listener = listener;
         new NavigationModelData(userName);
    }



    public void onViewClicked() {
        listener.onClick(userName);
    }



    public interface itemClick{
        void onClick(String value);
    }

}
