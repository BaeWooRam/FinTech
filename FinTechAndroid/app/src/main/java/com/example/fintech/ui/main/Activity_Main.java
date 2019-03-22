package com.example.fintech.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.ui.payment.card.Activity_Card;
import com.example.fintech.util.CommonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Main extends BaseActivity implements Contract_Main.mvpView, View.OnClickListener {
    @BindView(R.id.menu_news) TextView ivNews;
    @BindView(R.id.menu_qna) ImageView ivQNA;
    @BindView(R.id.menu_qr) ImageView ivQR;
    @BindView(R.id.menu_siren) ImageView ivSiren;
    @BindView(R.id.card_img) ImageView ivCard;

    private Presenter_Main mPresenter;
    private BaseActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SetUp();
    }

    @Override
    public void SetUp() {
        mContext = this;
        setPresenter();
        initActivity();

    }
    @Override
    public void setPresenter() {
        mPresenter = new Presenter_Main();
    }

    @OnClick(R.id.card_img)
    public void OnClickCard(){
        showMessage("아직 준비중입니다.");
//        CommonUtils.GoToActivity(mContext, Activity_Card.class);
    }

    @Override
    public void onClick(View v) {
        mPresenter.MenuClickEvent(v,mContext);
    }

    @Override
    public void initActivity() {
        ivQNA.setOnClickListener(this);
        ivQR.setOnClickListener(this);
        ivNews.setOnClickListener(this);
        ivSiren.setOnClickListener(this);
    }
}
