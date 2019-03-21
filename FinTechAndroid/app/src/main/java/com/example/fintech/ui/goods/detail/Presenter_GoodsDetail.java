package com.example.fintech.ui.goods.detail;


import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.data.vo.Goods;
import com.example.fintech.ui.goods.Adapter_Goods;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter_GoodsDetail implements Contract_GoodsDetail.Presenter {

    @Override
    public void NetworkingGetGoods(final BaseActivity context, final TextView tvName, final TextView tvPrice, final ImageView ivImage) {
        context.showLoading();

        Call<Goods> call = APIServerHelper.getRetrofitClient().doGetGoods();
        call.enqueue(new Callback<Goods>() {
            @Override
            public void onResponse(Call<Goods> call, Response<Goods> response) {
                tvName.setText(response.body().getGoods_name());
                tvPrice.setText(response.body().getGoods_price());
                Picasso.get()
                        .load(response.body().getGoods_image())
                        .error(R.drawable.ic_logo)
                        .into(ivImage);
                context.hideLoading();

            }

            @Override
            public void onFailure(Call<Goods> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });
    }

    @Override
    public void NetworkingGetOrder(final BaseActivity context, String id) {
        context.showLoading();

        Call<Goods> call = APIServerHelper.getRetrofitClient().doInsertOrder(id);
        call.enqueue(new Callback<Goods>() {
            @Override
            public void onResponse(Call<Goods> call, Response<Goods> response) {
                context.hideLoading();
            }

            @Override
            public void onFailure(Call<Goods> call, Throwable t) {
                context.showMessage("네트워킹 에러!");
                context.hideLoading();
            }
        });
    }
}
