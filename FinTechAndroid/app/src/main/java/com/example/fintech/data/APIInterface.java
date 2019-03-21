package com.example.fintech.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
//
    @GET("payment/testUser?identifier={email}")
    Call<Void> doGetID(@Query("email") String email);
//
//    @FormUrlEncoded
//    @POST("myPage/shopping")
//    Call<List<Cart>> doGetShoppingList(@Field("email") String email);

}
