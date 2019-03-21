package com.example.fintech.ui.main;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class Activity_Main extends BaseActivity implements Contract_Main.mvpView {
    @BindView(R.id.menu_news) ImageView ivNews;
    @BindView(R.id.menu_qna) ImageView ivQNA;
    @BindView(R.id.menu_qr) ImageView ivQR;
    @BindView(R.id.menu_siren) ImageView ivSiren;

    private Presenter_Main mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void SetUp() {
        setPresenter();

    }
    @Override
    public void setPresenter() {
        mPresenter = new Presenter_Main();
    }
}
