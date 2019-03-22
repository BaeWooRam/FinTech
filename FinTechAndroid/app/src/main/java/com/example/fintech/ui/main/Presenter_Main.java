package com.example.fintech.ui.main;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.ui.goods.Activity_Goods;
import com.example.fintech.ui.payment.Activity_Payment;
import com.example.fintech.ui.payment.payhistory.Activity_PayHistory;
import com.example.fintech.util.CommonUtils;


public class Presenter_Main implements Contract_Main.Presenter {

    @Override
    public void MenuClickEvent(View view, BaseActivity Context) {
        int id = view.getId();
        switch (id){
            case R.id.menu_news:
                CommonUtils.GoToActivity(Context, Activity_PayHistory.class);
                break;
            case R.id.menu_qna:
                Context.showMessage("아직 준비중인 서비스 입니다.^^");
                break;
            case R.id.menu_qr:
                CommonUtils.GoToActivity(Context, Activity_Goods.class);
                break;
            case R.id.menu_siren:
                CommonUtils.GoToActivity(Context, Activity_Goods.class);
                break;
        }
    }
}
