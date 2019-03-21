package com.example.fintech.ui.goods;

import android.view.View;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;

public interface Contract_Goods {
    interface mvpView extends MvpView<Presenter> {
        void InitActivity();
        void setRecyclerView();
    }

    interface Presenter extends MvpPresenter {
//        void NaverLogin();
//        void CheckPermission();
        void MenuBackClickEvent(BaseActivity activity);
//        void ClickBackKey(Activity activity);
//        void NaviClickEvent(MenuItem item, BaseActivity activity);
    }
}
