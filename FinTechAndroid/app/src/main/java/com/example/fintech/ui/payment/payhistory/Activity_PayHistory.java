package com.example.fintech.ui.payment.payhistory;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.ui.goods.Adapter_Goods;
import com.example.fintech.ui.goods.RvItemTouchListener;
import com.example.fintech.ui.goods.detail.Activity_GoodsDetail;
import com.example.fintech.util.CommonUtils;
import com.example.fintech.util.RecyclerCreateLineUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_PayHistory extends BaseActivity implements Contract_PayHistory.mvpView,View.OnClickListener{

    @BindView(R.id.rv_goods) RecyclerView rvGoods;

    private BaseActivity mContext;
    private Presenter_PayHistory mPresenter;
    private Adapter_PayHistory mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);

        SetUp();
    }

    @Override
    public void SetUp() {
        mContext = this;
        setPresenter();
        setRecyclerView();
        InitActivity();

    }

    @Override
    public void setPresenter() {
        mPresenter = new Presenter_PayHistory();
    }

    @Override
    public void InitActivity() {
        //toolbar 세팅
        View CustomView = View.inflate(mContext, R.layout.toolbar_payhistory,null);
        ((ImageButton)CustomView.findViewById(R.id.btnBack)).setOnClickListener(this);
        setUpToolbar(CustomView);

        mPresenter.NetworkingGetPayHistoryList(mContext,mAdapter);
    }

    @Override
    public void setRecyclerView() {
        rvGoods.addItemDecoration(new RecyclerCreateLineUtils(4));

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        LayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvGoods.setLayoutManager(LayoutManager);
        rvGoods.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new Adapter_PayHistory();
        rvGoods.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
