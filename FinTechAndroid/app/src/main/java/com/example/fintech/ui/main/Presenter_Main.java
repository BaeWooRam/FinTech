package com.example.fintech.ui.main;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;


public class Presenter_Main implements Contract_Main.Presenter {

    @Override
    public void MenuClickEvent(View view, BaseActivity Context) {
        int id = view.getId();
        switch (id){
            case R.id.menu_news:
                break;
            case R.id.menu_qna:
                break;
            case R.id.menu_qr:
                break;
            case R.id.menu_siren:
                break;
        }
    }
}
