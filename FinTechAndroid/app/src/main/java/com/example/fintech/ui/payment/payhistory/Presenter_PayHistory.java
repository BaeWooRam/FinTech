package com.example.fintech.ui.payment.payhistory;


import android.util.Log;

import com.example.fintech.FinTechApplication;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.data.APIServerHelper;
import com.example.fintech.data.vo.Beverage;
import com.example.fintech.data.vo.Food;
import com.example.fintech.data.vo.MemberShip;
import com.example.fintech.data.vo.PayHistory;
import com.example.fintech.data.vo.PayHistoryList;
import com.example.fintech.ui.goods.Adapter_Goods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter_PayHistory implements Contract_PayHistory.Presenter {
    private static final int GOODS_NAME = 0;
    @Override
    public void NetworkingGetPayHistoryList(final BaseActivity context, final Adapter_PayHistory adapter) {
        context.showLoading();
        FinTechApplication app = (FinTechApplication) context.getApplicationContext();
        MemberShip mem = app.getMemberInfo();
        if(mem != null){
            Call<List<PayHistory>> call = APIServerHelper.getRetrofitClient().doGetReceiptList(mem.getAtoken());
            call.enqueue(new Callback<List<PayHistory>>() {
                @Override
                public void onResponse(Call<List<PayHistory>> call, Response<List<PayHistory>> response) {
                    ArrayList<PayHistory> list= (ArrayList<PayHistory>) response.body();
                    if(list !=null)
                        adapter.setItems(list);
                    context.hideLoading();

                }

                @Override
                public void onFailure(Call<List<PayHistory>> call, Throwable t) {
                    context.showMessage("네트워킹 에러!");
                    context.hideLoading();
                }
            });
        }else
            context.showMessage("결제 영수증을 조회할 수 없습니다, 다시 시도해주세요.");
    }
}
