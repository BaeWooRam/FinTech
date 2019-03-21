package com.example.fintech.ui.login;


import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.ui.login.mem.Activity_Member;
import com.example.fintech.ui.main.Activity_Main;
import com.example.fintech.util.CommonUtils;
import com.example.fintech.util.ContractUtils;
import com.example.fintech.util.MemberUtils;
import com.example.fintech.util.SHAUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter_Login implements Contract_Login.Presenter {
    //싱글톤

    @Override
    public void Login(EditText etID, EditText etPWD, BaseActivity context) {
        String id = etID.getText().toString().trim();
        String pwd = etPWD.getText().toString().trim();
//        Log.e("Login id",id);
//        Log.e("Login pwd",pwd);
        boolean isID = MemberUtils.CheckID(id);
        boolean isPWD = MemberUtils.CheckPwd(pwd);
        if(isID){
            if(isPWD) {
                String sha_pwd = SHAUtils.getSHA512(pwd);
                NetworkingSendID(id, sha_pwd,context);
            }else{
                context.showMessage("비밀번호를 잘못입력하셨습니다.\n 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함");
            }
        }else{
            context.showMessage("이메일을 잘못 입력하셨습니다. 다시 한번 확인해주세요!");
        }
    }

    @Override
    public void ClickEventMember(Activity context) {
        CommonUtils.GoToActivity(context, Activity_Member.class);
    }





    private void NetworkingSendID(String id, String pwd, final BaseActivity context){
        context.showLoading();

        Call<String> call = APIServerHelper.getRetrofitClient().doGetLogin(id,pwd);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res = response.body();
                CommonUtils.GoToActivity(context, Activity_Main.class);
                context.hideLoading();
//                if(res.equals(ContractUtils.NETWORKING_CONFIRM))
//                    CommonUtils.GoToActivity(context, Activity_Main.class);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                context.showMessage("아이디와 비밀번호를 다시한번 확인해주세요!");
                context.hideLoading();
            }
        });

    }

}
