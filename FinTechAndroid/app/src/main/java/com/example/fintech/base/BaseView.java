package com.example.fintech.base;

import android.support.annotation.StringRes;
import android.view.View;
public interface BaseView{
    void showMessage(String message);
    void hideLoading();
    void showLoading();
    void showMessage(@StringRes int resId);
    void setUpToolbar(View view);
    void setUpToolbar(int layoutID, String title);
}
