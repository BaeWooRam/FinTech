package com.example.fintech.data;

import com.example.fintech.data.vo.Goods;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
//
    @GET("payment/login")
    Call<String> doGetLogin(@Query("email") String email,@Query("password") String password);

    @GET("payment/checkID")
    Call<String> doGetCheckID(@Query("email") String email);

    @GET("payment/signup")
    Call<String> doGetCreateID(@Query("email") String email,@Query("name") String name,@Query("password") String password);

    @GET("payment/checkID")
    Call<List<Goods>> doGetFoodsList();

    @GET("payment/checkID")
    Call<List<Goods>> doGetCoffeeList();

    @GET("payment/checkID")
    Call<Goods> doGetGoods();

    @GET("payment/checkID")
    Call<Goods> doInsertOrder(@Query("_id") String _id);
//
//    @FormUrlEncoded
//    @POST("myPage/shopping")
//    Call<List<Cart>> doGetShoppingList(@Field("email") String email);

}
