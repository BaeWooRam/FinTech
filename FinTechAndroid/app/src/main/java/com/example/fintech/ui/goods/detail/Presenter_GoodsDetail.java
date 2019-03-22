package com.example.fintech.ui.goods.detail;


import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.FinTechApplication;
import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.data.vo.Beverage;
import com.example.fintech.data.vo.Food;
import com.example.fintech.data.vo.Goods;
import com.example.fintech.data.vo.MemberShip;
import com.example.fintech.ui.goods.Activity_Goods;
import com.example.fintech.ui.goods.Adapter_Goods;
import com.example.fintech.ui.payment.Activity_Payment;
import com.example.fintech.util.CommonUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter_GoodsDetail implements Contract_GoodsDetail.Presenter {

    private Goods info;

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }

    @Override
    public void NetworkingGetGoods(final BaseActivity context, String id, String Category, final TextView tvName, final TextView tvPrice, final ImageView ivImage) {
        context.showLoading();
        int index = Integer.parseInt(Category);

        switch (index){
            case 0:
                NetworkingGetCoffee(context,id,tvName,tvPrice,ivImage);
                break;

            case 1:
                NetworkingGetFood(context,id,tvName,tvPrice,ivImage);
                break;
        }
    }

    @Override
    public void NetworkingGetOrder(final BaseActivity context, String productID, String productPrice) {
        context.showLoading();
        FinTechApplication app = (FinTechApplication) context.getApplicationContext();
        MemberShip mem = app.getMemberInfo();
        if(mem != null){
            Log.e("Order",mem.getAtoken());
            Log.e("Order",mem.getId());
            Log.e("Order",productID);
            Log.e("Order",productPrice);
            Call<String> call = APIServerHelper.getRetrofitClient().doInsertOrder(mem.getAtoken(),mem.getId(), productPrice,productID);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    int res = Integer.parseInt(response.body());
                    if(res>0){
                        CommonUtils.GoToActivity(context,response.body(),Activity_Payment.class);
                        context.finish();
                    }
                    else
                        context.showMessage("주문 번호 조회 안됩니다. 다시 시도해주세요");
                    context.hideLoading();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    context.showMessage("네트워킹 에러!");
                    context.hideLoading();
                }
            });
        }else
            context.showMessage("회원정보나 토큰이 없습니다!");

    }

    public void NetworkingGetFood(final BaseActivity context,String id, final TextView tvName, final TextView tvPrice, final ImageView ivImage){
        context.showLoading();

        Call<Food> call = APIServerHelper.getRetrofitClient().doGetSelectFoods(id);
        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if(response.body() !=null){
                    tvName.setText(response.body().getGoods_name());
                    tvPrice.setText(response.body().getGoods_price());
                    Picasso.get()
                            .load(response.body().getGoods_image())
                            .error(R.drawable.ic_logo)
                            .into(ivImage);

                    setInfo(response.body());
                }else
                    context.showMessage("응답 에러!");

                context.hideLoading();

            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });

    }

    public void NetworkingGetCoffee(final BaseActivity context,String id, final TextView tvName, final TextView tvPrice, final ImageView ivImage){
        context.showLoading();

        Call<Beverage> call = APIServerHelper.getRetrofitClient().doGetSelectBeverage(id);
        call.enqueue(new Callback<Beverage>() {
            @Override
            public void onResponse(Call<Beverage> call, Response<Beverage> response) {
                if(response.body() !=null){
                    tvName.setText(response.body().getGoods_name());
                    tvPrice.setText(response.body().getGoods_price());
                    Picasso.get()
                            .load(response.body().getGoods_image())
                            .error(R.drawable.ic_logo)
                            .into(ivImage);

                    setInfo(response.body());
                }else
                    context.showMessage("응답 에러!");

                context.hideLoading();

            }

            @Override
            public void onFailure(Call<Beverage> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });

    }
}
