package com.example.fintech.ui.goods.detail;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;
import com.example.fintech.ui.goods.Adapter_Goods;

public interface Contract_GoodsDetail {
    interface mvpView extends MvpView<Presenter> {
        void InitActivity();
    }

    interface Presenter extends MvpPresenter {
        void NetworkingGetGoods(final BaseActivity context, String id, String Category, final TextView tvName, final TextView tvPrice, final ImageView ivImage);
        void NetworkingGetOrder(final BaseActivity context, String productID, String productPrice);
    }
}
