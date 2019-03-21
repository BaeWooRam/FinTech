package com.example.fintech.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Login extends BaseActivity implements Contract_Login.mvpView {
    @BindView(R.id.btnlogin) Button btnLogin;
    @BindView(R.id.et_id) EditText etID;
    @BindView(R.id.et_pwd) EditText etPWD;

    private Presenter_Login mPresenter;
    private BaseActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        SetUp();
    }

    @Override
    public void SetUp() {
        setPresenter();
        mContext = this;
    }

    @OnClick(R.id.btnlogin)
    public void OnClickLogin(){
        mPresenter.Login(etID,etPWD,mContext);
    }

    @Override
    public void setPresenter() {
        mPresenter = new Presenter_Login();
    }
}
