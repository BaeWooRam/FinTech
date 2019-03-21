package com.example.fintech.ui.login.mem;

import android.widget.EditText;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.base.MvpPresenter;
import com.example.fintech.base.MvpView;

public interface Contract_Member {
    interface mvpView extends MvpView<Presenter> {
    }

    interface Presenter extends MvpPresenter {
        void CreateMember(EditText etID, EditText etPWD, EditText etName,BaseActivity context);
        void CheckDuplicationMember(EditText etID, BaseActivity context);
    }
}
