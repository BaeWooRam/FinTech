package com.example.fintech.ui.goods.detail;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.vo.Goods;
import com.example.fintech.ui.goods.Activity_Goods;
import com.example.fintech.ui.goods.Adapter_Goods;
import com.example.fintech.ui.goods.Presenter_Goods;
import com.example.fintech.util.ContractUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_GoodsDetail extends BaseActivity implements Contract_GoodsDetail.mvpView, View.OnClickListener{
    @BindView(R.id.goods_name) TextView tvName;
    @BindView(R.id.goods_price) TextView tvPrice;
    @BindView(R.id.goods_img) ImageView ivImage;
    @BindView(R.id.btncold) Button btnCold;
    @BindView(R.id.btnhot) Button btnHot;
    @BindView(R.id.btnorder) Button btnOrder;

    private BaseActivity mContext;
    private Presenter_GoodsDetail mPresenter;
    private String[] mGoodsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        SetUp();
    }

    @Override
    public void SetUp() {
        mContext = this;
        setPresenter();
        InitActivity();
    }

    @OnClick(R.id.btncold)
    public void OnClickBtnCold(){
        btnCold.setBackgroundResource(R.drawable.ic_bt_confirm3);
        btnCold.setTextColor(Color.WHITE);
        btnHot.setBackgroundResource(R.drawable.ic_bt_confirm1);
        btnHot.setTextColor(Color.BLACK);
    }

    @OnClick(R.id.btnhot)
    public void OnClickBtnHot(){
        btnHot.setBackgroundResource(R.drawable.ic_bt_confirm2);
        btnHot.setTextColor(Color.WHITE);
        btnCold.setBackgroundResource(R.drawable.ic_bt_confirm1);
        btnCold.setTextColor(Color.BLACK);
    }

    @OnClick(R.id.btnorder)
    public void OnClickBtnOrder(){
        Goods info = mPresenter.getInfo();
        if(info !=null)
            mPresenter.NetworkingGetOrder(mContext,mGoodsInfo[Activity_Goods.INTEND_POSTION_ID],info.getGoods_price());
        else
            showMessage("선택하신 메뉴에 정보가 없습니다!");
    }
    @Override
    public void setPresenter() {
        mPresenter = new Presenter_GoodsDetail();
    }

    @Override
    public void InitActivity() {
        //toolbar 세팅
        View CustomView = View.inflate(mContext, R.layout.toolbar_detail,null);
        ((ImageButton)CustomView.findViewById(R.id.btnBack)).setOnClickListener(this);
        setUpToolbar(CustomView);

        mGoodsInfo = getIntent().getStringArrayExtra(Activity_Goods.INTEND_NAME);
        mPresenter.NetworkingGetGoods(mContext,mGoodsInfo[Activity_Goods.INTEND_POSTION_ID],mGoodsInfo[Activity_Goods.INTEND_POSTION_CATEGORY],tvName,tvPrice,ivImage);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
