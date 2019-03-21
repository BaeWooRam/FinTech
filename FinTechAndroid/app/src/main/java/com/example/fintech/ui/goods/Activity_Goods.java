package com.example.fintech.ui.goods;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;

import butterknife.BindView;

public class Activity_Goods extends BaseActivity implements Contract_Goods.mvpView, View.OnClickListener {

    @BindView(R.id.rv_goods) RecyclerView rvGoods;

    private BaseActivity mContext;
    private Presenter_Goods mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
    }

    @Override
    public void SetUp() {
        mContext = this;

    }

    @Override
    public void setPresenter() {
        mPresenter = new Presenter_Goods();
    }

    @Override
    public void InitActivity() {
        //toolbar 세팅
        View CustomView = View.inflate(mContext, R.layout.toolbar,null);
        ((ImageButton)CustomView.findViewById(R.id.btnBack)).setOnClickListener(this);
        ((TextView)CustomView.findViewById(R.id.toolbar_title)).setText("전체 메뉴");

        setUpToolbar(CustomView);
    }

    @Override
    public void setRecyclerView() {

    }

    @Override
    public void onClick(View v) {
        mPresenter.MenuBackClickEvent(mContext);
    }
}
