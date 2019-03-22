package com.example.fintech.data;

import com.example.fintech.data.vo.Beverage;
import com.example.fintech.data.vo.Food;
import com.example.fintech.data.vo.MemberShip;
import com.example.fintech.data.vo.PayHistory;
import com.example.fintech.data.vo.PayHistoryList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
//
    @POST("payment/login")
    Call<MemberShip> doGetLogin(@Query("email") String email, @Query("password") String password);

    @GET("payment/checkID")
    Call<String> doGetCheckID(@Query("email") String email);

    @GET("payment/signup")
    Call<String> doGetCreateID(@Query("email") String email,@Query("name") String name,@Query("password") String password);

    @GET("payment/getFoodList")
    Call<List<Food>> doGetFoodsList();

    @GET("payment/getFood")
    Call<Food> doGetSelectFoods(@Query("_id") String id);

    @GET("payment/getBeverageList")
    Call<List<Beverage>> doGetBeverageList();

    @GET("payment/getBeverage")
    Call<Beverage> doGetSelectBeverage(@Query("_id") String id);

    @GET("payment/getReceiptList")
    Call<List<PayHistory>> doGetReceiptList(@Query("atoken") String atoken);

    @POST("payment/orderProduct")
    Call<String> doInsertOrder(@Query("atoken") String atoken,@Query("owner_id") String _id, @Query("amount") String price, @Query("product_id")String product_id);
//
//    @FormUrlEncoded
//    @POST("myPage/shopping")
//    Call<List<Cart>> doGetShoppingList(@Field("email") String email);

}
