package com.example.fintech.ui.goods.detail;

import android.os.Bundle;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;

public class Activity_GoodsDetail extends BaseActivity implements Contract_GoodsDetail.mvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void SetUp() {

    }

    @Override
    public void setPresenter() {

    }
}
