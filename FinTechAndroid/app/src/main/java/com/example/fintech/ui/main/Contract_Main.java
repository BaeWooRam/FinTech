package com.example.fintech.ui.main;

import android.app.Activity;
import android.view.MenuItem;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;

public interface Contract_Main {
    interface mvpView extends MvpView<Presenter> {
        void setBottomNavigation();
    }

    interface Presenter extends MvpPresenter {
//        void NaverLogin();
//        void CheckPermission();
//        void CategoryClickEvent(View v);
//        void ClickBackKey(Activity activity);
//        void NaviClickEvent(MenuItem item, BaseActivity activity);
    }
}
