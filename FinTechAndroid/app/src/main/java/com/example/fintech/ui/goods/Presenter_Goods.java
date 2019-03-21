package com.example.fintech.ui.goods;


import android.view.View;

import com.example.fintech.base.BaseActivity;

public class Presenter_Goods implements Contract_Goods.Presenter {

    @Override
    public void MenuBackClickEvent(BaseActivity activity) {
        activity.finish();
    }
}
