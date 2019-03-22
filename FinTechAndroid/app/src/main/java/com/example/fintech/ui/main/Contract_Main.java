package com.example.fintech.ui.main;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;

public interface Contract_Main {
    interface mvpView extends MvpView<Presenter> {
        void initActivity();
    }

    interface Presenter extends MvpPresenter {
        void MenuClickEvent(View view, BaseActivity Context);
    }
}
