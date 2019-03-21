package com.example.fintech.ui.login;

import android.widget.EditText;
import android.widget.TextView;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;

public interface Contract_Login {
    interface mvpView extends MvpView<Presenter> {
    }

    interface Presenter extends MvpPresenter {
        void Login(EditText etID, EditText etPWD, BaseActivity context);
        void CreateMemberShip();

    }
}
