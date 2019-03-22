package com.example.fintech.ui.goods;


import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.data.vo.Beverage;
import com.example.fintech.data.vo.Food;

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

        Call<List<Food>> call = APIServerHelper.getRetrofitClient().doGetFoodsList();
        call.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                ArrayList<Food> list = (ArrayList<Food>) response.body();
                if(list !=null)
                    adapter.setItems(list);
                context.hideLoading();

            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });

    }

    @Override
    public void NetworkingGetCoffeeList(final BaseActivity context, final Adapter_Goods adapter){
        context.showLoading();

        Call<List<Beverage>> call = APIServerHelper.getRetrofitClient().doGetBeverageList();
        call.enqueue(new Callback<List<Beverage>>() {
            @Override
            public void onResponse(Call<List<Beverage>> call, Response<List<Beverage>> response) {
                ArrayList<Beverage> list = (ArrayList<Beverage>) response.body();
                if(list !=null)
                    adapter.setItems(list);
                context.hideLoading();

            }

            @Override
            public void onFailure(Call<List<Beverage>> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });

    }
}
