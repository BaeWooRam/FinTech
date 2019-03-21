package com.example.fintech.ui.goods;


import android.view.View;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.data.vo.Goods;
import com.example.fintech.ui.main.Activity_Main;
import com.example.fintech.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter_Goods implements Contract_Goods.Presenter {
    private static final int GOODS_NAME = 0;
    private static final int GOODS_PRICE = 1;
    private static final int GOODS_IMAGE = 2;
    private static final int GOODS_MAX = 3;
    @Override
    public void MenuBackClickEvent(BaseActivity activity) {
        activity.finish();
    }

    @Override
    public void NetworkingGetFoodList(final BaseActivity context, final Adapter_Goods adapter){
        context.showLoading();

        Call<List<Goods>> call = APIServerHelper.getRetrofitClient().doGetFoodsList();
        call.enqueue(new Callback<List<Goods>>() {
            @Override
            public void onResponse(Call<List<Goods>> call, Response<List<Goods>> response) {
                adapter.setItems((ArrayList<Goods>) response.body());
                context.hideLoading();

            }

            @Override
            public void onFailure(Call<List<Goods>> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });

    }

    @Override
    public void NetworkingGetCoffeeList(final BaseActivity context, final Adapter_Goods adapter){
        context.showLoading();

        Call<List<Goods>> call = APIServerHelper.getRetrofitClient().doGetCoffeeList();
        call.enqueue(new Callback<List<Goods>>() {
            @Override
            public void onResponse(Call<List<Goods>> call, Response<List<Goods>> response) {
                adapter.setItems((ArrayList<Goods>) response.body());
                context.hideLoading();

            }

            @Override
            public void onFailure(Call<List<Goods>> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });

    }
}
