package com.example.fintech.data;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServerHelper {
    private static int CONNECT_TIMEOUT = 30;
    private static String SERVER_URL ="http://192.168.20.7:8080/";
    private static  OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public static APIInterface getRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(SERVER_URL)//movieUri
                .client(getOkHttpClient())//httpClient연결을 통해 log 확인
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava2를 사용하도록 Factory생성
                .addConverterFactory(GsonConverterFactory.create())//Gson을 쓸 수 있도록 Factory생성
                .build().create(APIInterface.class);//MovieService Interface사용
    }
}
