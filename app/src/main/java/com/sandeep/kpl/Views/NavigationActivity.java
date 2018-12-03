package com.sandeep.kpl.Views;

import android.annotation.SuppressLint;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sandeep.kpl.R;
import com.sandeep.kpl.ViewModels.NavigationActivityViewModel;
import com.sandeep.kpl.ViewModels.NavigationViewModel;
import com.sandeep.kpl.ViewModels.RecylerViewAdapter;
import com.sandeep.kpl.ViewModels.Utils;
import com.sandeep.kpl.databinding.ActivityNavigationBinding;

public class NavigationActivity extends BaseActivity implements NavigationViewModel.itemClick {

    private static final String TAG = NavigationActivity.class.getSimpleName();
    private ActivityNavigationBinding mBinding;
    private WebView mWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(NavigationActivity.this,R.layout.activity_navigation);
        mBinding.setViewModel(new NavigationActivityViewModel());
        mWebview = mBinding.webView ;
        loadWebView();
        mWebview.loadUrl(Utils.BASE_URL);


        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(NavigationActivity.this));
        mBinding.recyclerView.setAdapter(new RecylerViewAdapter(this));

    }


    @Override
    public void onClick(String value) {
        for (String val : Utils.listofNavigationItems()) {
            switch (val) {
                case "College":
                    navigatePage("college/" + val);
                    break;
                case "School":
                    navigatePage("school/" + val);
                    break;
                case "SI":
                    navigatePage(Utils.SI_EVENTS_PAGE);
                    break;
                case "D.S.C.":
                    navigatePage("dsc" + val);
                    break;
            }

        }
    }

        public void navigatePage(String value) {
            if (Utils.isOnline()) {
                // get information from the backend and save the page to database
                mWebview.loadUrl(value);

            } else {
                // load the page from the backend into the main page ui directly
            }
        }

        @SuppressLint("SetJavaScriptEnabled")
        public void loadWebView() {
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

        });
        }


}
