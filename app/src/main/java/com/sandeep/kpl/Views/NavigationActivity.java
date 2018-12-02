package com.sandeep.kpl.Views;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.sandeep.kpl.R;
import com.sandeep.kpl.ViewModels.NavigationActivityViewModel;
import com.sandeep.kpl.ViewModels.RecylerViewAdapter;
import com.sandeep.kpl.ViewModels.Utils;
import com.sandeep.kpl.databinding.ActivityNavigationBinding;

public class NavigationActivity extends BaseActivity {

    private static final String TAG = NavigationActivity.class.getSimpleName();
    private ActivityNavigationBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(NavigationActivity.this,R.layout.activity_navigation);
        mBinding.setViewModel(new NavigationActivityViewModel());


        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(NavigationActivity.this));
        mBinding.recyclerView.setAdapter(new RecylerViewAdapter());

    }

    @BindingAdapter("itemClicked")
    public static void itemClicked(View view , String viewClicked) {

        for (String val : Utils.listofNavigationItems()) {
            switch (val) {
                case "College" :
                    if (Utils.isOnline()) {

                    } else {

                    }
                    break;
                case "D.S.C." :
                    if (Utils.isOnline()) {

                    } else {

                    }
                    break;
                case "SI" :
                    if (Utils.isOnline()) {

                    } else {

                    }
                    break;
                case "Library" :
                    if (Utils.isOnline()) {

                    } else {

                    }
                    break;

            }
        }


    }
}
