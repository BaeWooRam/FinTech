package com.example.fintech.ui.login.mem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Member extends BaseActivity implements Contract_Member.mvpView {
    @BindView(R.id.mem_name) EditText etName;
    @BindView(R.id.mem_email) EditText etEmail;
    @BindView(R.id.mem_pwd) EditText etPWD;
    @BindView(R.id.mem_btnConfirm) Button btnConfirm;

    private Presenter_Member mPresenter;
    private BaseActivity mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        ButterKnife.bind(this);
        SetUp();
    }

    @Override
    public void SetUp() {
        setPresenter();
        mContext = this;
        etEmail.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
            mPresenter.CheckDuplicationMember(etEmail,mContext);
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
     });
    }

    @OnClick(R.id.mem_btnConfirm)
    public void OnClickConfirm(){
        mPresenter.CreateMember(etEmail,etPWD,etName,mContext);
    }
    @Override
    public void setPresenter() {
        mPresenter = new Presenter_Member();
    }
}
