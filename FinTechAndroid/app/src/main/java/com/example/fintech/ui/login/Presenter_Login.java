package com.example.fintech.ui.login;


import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.data.MsUrl;

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
        Log.e("Login id",id);
        Log.e("Login pwd",pwd);
        boolean isID = CheckID(id);
        boolean isPWD = CheckPwd(pwd);
        if(isID){
            if(isPWD) {
                NetworkingSendID(id);
            }else{
                context.showMessage("비밀번호를 잘못입력하셨습니다.\n 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함");
            }
        }else{
            context.showMessage("이메일을 잘못 입력하셨습니다. 다시 한번 확인해주세요!");
        }
    }

    private boolean CheckID(String id){
        String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(id);

        boolean isNormal = m.matches();
        return isNormal;
    }

    //가장 많이 사용되는 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
        private boolean CheckPwd(String pwd){
            Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
            Matcher m = p.matcher(pwd);
    
            if(m.matches()){
                return true;
            }
            return false;
    
        }



    private void NetworkingSendID(String id){
        Call<Void> call = APIServerHelper.getRetrofitClient().doGetID(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.e("CALL ok", "handleMessage: ");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("CALL no", "handleMessage: ");
            }
        });
        new MsUrl().m_getContext_fromWebSite_sendPost("http://192.168.30.37:8080/payment/testUser?identifier="+id,"",new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.e("HANDLER ok", "handleMessage: ");
            }
        });
    }

    @Override
    public void CreateMemberShip() {

    }
}
