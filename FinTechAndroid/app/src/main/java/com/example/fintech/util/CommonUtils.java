/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.example.fintech.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.view.View;

import com.example.fintech.R;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by janisharali on 27/01/17.
 */

public final class CommonUtils {

    private static final String TAG = "CommonUtils";
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName)
            throws IOException {

        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat(TIMESTAMP_FORMAT, Locale.KOREA).format(new Date());
    }

    public static void GoToActivity(Activity activity, Class gotoActivity){
        Intent intent= new Intent(activity.getApplicationContext(), gotoActivity);
        activity.startActivity(intent);
    }
    public static void GoToActivity(Activity activity, String str, Class gotoActivity){
        Intent intent= new Intent(activity.getApplicationContext(), gotoActivity);
        intent.putExtra(ContractUtils.INTENT_STR, str);
        activity.startActivity(intent);
    }

    //위에 있는 함수로는 put name을 정할수 없길래 밑에 만들었는데 잘못한 것이라면 수정할게요!
    public static void GoToActivity(Activity activity, String[] str, String name, Class gotoActivity){
        Intent intent= new Intent(activity.getApplicationContext(), gotoActivity);
        intent.putExtra(name,str);
        activity.startActivity(intent);
    }

    //제가 2가지 레이아웃을 보이고 숨기고 하는것을 자주 사용해서 만들었어요!
    public static void VisibilityView(View visible, View gone){
        visible.setVisibility(View.VISIBLE);
        gone.setVisibility(View.GONE);
    }

    public static int CheckPrice(String price){
        int p;
        if(price != null)
            p =Integer.parseInt(price);
        else
            p = 0;

        return p;
    }

    public static void DiaryDialog(Context context,String message, DialogInterface.OnClickListener nogative, DialogInterface.OnClickListener positive){
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setNegativeButton("취소", nogative)
                .setPositiveButton("확인", positive)
                .show();
    }

    public static void DiaryDialog(Context context,String message){
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("확인",null)
                .show();
    }

}
