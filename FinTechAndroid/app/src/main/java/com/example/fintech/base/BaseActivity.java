package com.example.fintech.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fintech.R;
import com.example.fintech.util.CommonUtils;

public class BaseActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog mProgressDialog;


    @Override
    public void setUpToolbar(int layoutID, String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        View CustomView = View.inflate(getApplicationContext(),layoutID,null);
        actionBar.setCustomView(CustomView,new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT
        ));
        ((TextView)CustomView.findViewById(R.id.title)).setText(title);
        Toolbar perent = (Toolbar) CustomView.getParent();
        perent.setContentInsetsAbsolute(0,0);
    }

    @Override
    public void setUpToolbar(View view) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(view,new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT
        ));

        Toolbar perent = (Toolbar) view.getParent();
        perent.setContentInsetsAbsolute(0,0);

    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.string_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }
    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
