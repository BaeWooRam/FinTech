package com.example.fintech.ui.payment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.util.ContractUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Payment extends BaseActivity{
    @BindView(R.id.order_num)
    TextView tvOrder;
    @BindView(R.id.order_btnconfirm)
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        ButterKnife.bind(this);

        String orderNum = getIntent().getStringExtra(ContractUtils.INTENT_STR);
        tvOrder.setText(orderNum);
    }

    @OnClick(R.id.order_btnconfirm)
    public void OnClickConfirm(){
        finish();
    }
}
