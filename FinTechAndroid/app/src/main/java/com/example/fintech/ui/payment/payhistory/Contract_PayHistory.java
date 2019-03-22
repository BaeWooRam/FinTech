package com.example.fintech.ui.payment.payhistory;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;
import com.example.fintech.ui.goods.Adapter_Goods;

public interface Contract_PayHistory {
    interface mvpView extends MvpView<Presenter> {
        void InitActivity();
        void setRecyclerView();
    }

    interface Presenter extends MvpPresenter {
//        void NaverLogin();
//        void CheckPermission();
        void NetworkingGetPayHistoryList(final BaseActivity context, Adapter_PayHistory adapter);
//        void ClickBackKey(Activity activity);
//        void NaviClickEvent(MenuItem item, BaseActivity activity);
    }
}
