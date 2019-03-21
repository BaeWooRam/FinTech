package com.example.fintech.ui.goods.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.ui.goods.Adapter_Goods;
import com.example.fintech.ui.goods.Presenter_Goods;
import com.example.fintech.util.ContractUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_GoodsDetail extends BaseActivity implements Contract_GoodsDetail.mvpView{
    @BindView(R.id.rv_goods) TextView tvName;
    @BindView(R.id.goods_tab) TextView tvPrice;
    @BindView(R.id.goods_tab) ImageView ivImage;
    @BindView(R.id.goods_tab) Button btnCold;
    @BindView(R.id.goods_tab) Button btnHot;
    @BindView(R.id.goods_tab) Button btnOrder;

    private BaseActivity mContext;
    private Presenter_GoodsDetail mPresenter;
    private String mGoods_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @Override
    public void SetUp() {
        mContext = this;
        setPresenter();
        InitActivity();
    }

    @OnClick()
    public void OnClickBtnCold(){

    }

    @OnClick()
    public void OnClickBtnHot(){

    }

    @OnClick()
    public void OnClickBtnOrder(){
        mPresenter.NetworkingGetOrder(mContext,mGoods_id);
    }
    @Override
    public void setPresenter() {
        mPresenter = new Presenter_GoodsDetail();
    }

    @Override
    public void InitActivity() {
        mGoods_id = getIntent().getStringExtra(ContractUtils.INTENT_STR);
        mPresenter.NetworkingGetGoods(mContext,tvName,tvPrice,ivImage);
    }
}
