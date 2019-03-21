package com.example.fintech.ui.login.mem;


import android.util.Log;
import android.widget.EditText;

import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.ui.login.Contract_Login;
import com.example.fintech.util.CommonUtils;
import com.example.fintech.util.ContractUtils;
import com.example.fintech.util.MemberUtils;
import com.example.fintech.util.SHAUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.fintech.util.MemberUtils.CheckID;

public class Presenter_Member implements Contract_Member.Presenter {
    //싱글톤
    private boolean isCheckEmail = false;

    @Override
    public void CreateMember(EditText etID, EditText etPWD, EditText etName, BaseActivity context) {
        String pwd = etPWD.getText().toString().trim();
        String email = etID.getText().toString().trim();
        String name = etName.getText().toString().trim();
        boolean isPWD = MemberUtils.CheckPwd(pwd);
        if(isPWD) {
            String sha_pwd = SHAUtils.getSHA512(pwd);
            NetworkingSendMember(email,sha_pwd,name,context);
        }else{
            context.showMessage("비밀번호를 잘못입력하셨습니다.\n 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함");
        }
    }

    @Override
    public void CheckDuplicationMember(EditText etID, BaseActivity context) {
        String id = etID.getText().toString().trim();

        //먼저 유효성 검사
        boolean isID = MemberUtils.CheckID(id);
        if (isID) {
           NetworkingSendCheckEmail(id,etID);
        } else {
            etID.setError("이메일을 잘못 입력하셨습니다. 다시 한번 확인해주세요!");
        }

    }

    private void NetworkingSendMember(String email, String pwd, String name, final BaseActivity context){
        context.showLoading();

        Call<String> call = APIServerHelper.getRetrofitClient().doGetCreateID(email,name,pwd);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res = response.body();
                Log.e("CALL OK",res);
                context.showMessage("축하드립니다. 회원가입 되었습니다!");
                context.hideLoading();
                context.finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("CALL no", "handleMessage: ");
                context.hideLoading();
            }
        });

    }

    private void NetworkingSendCheckEmail(String email, final EditText text){
        Call<String> call = APIServerHelper.getRetrofitClient().doGetCheckID(email);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res = response.body();
                Log.e("CHECK EMAIL",res);
                if(res.endsWith(ContractUtils.NETWORKING_CONFIRM)){
                    isCheckEmail = true;
                    Log.e("아이디 사용 가능","ㄴㅇㄻㄴㅇㄹ");
                    text.setError("아이디 사용 가능합니다");
                }else{
                    isCheckEmail = false;
                    text.setError("아이디 중복");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("CALL no", "handleMessage: ");
            }
        });

    }


}
