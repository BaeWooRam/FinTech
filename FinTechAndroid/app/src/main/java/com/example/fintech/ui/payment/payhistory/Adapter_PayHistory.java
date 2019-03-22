package com.example.fintech.ui.payment.payhistory;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.data.vo.Goods;
import com.example.fintech.data.vo.PayHistory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_PayHistory extends RecyclerView.Adapter<Adapter_PayHistory.ViewHolder> {
    private ArrayList<PayHistory> items;

    public Adapter_PayHistory() {
        this.items = new ArrayList<>();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPayHistory;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPayHistory = itemView.findViewById(R.id.payhistory);
      ;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payhistory, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        String s1;
        String s2;
        String s3;
        String s4;

        if (items.get(position).getPayMenntPrice()!=null){
            s1 = items.get(position).getPayMenntPrice();
        }
        else
            s1 = "없음";

        if (items.get(position).getPayMenntPrice()!=null){
            s2 = items.get(position).getPayMentCardNo();
        }
        else
            s2 = "없음";
        if (items.get(position).getPayMenntPrice()!=null){
            s3 = items.get(position).getPayMentInstallment();
        }else
            s3 = "없음";

        if (items.get(position).getPayMenntPrice()!=null){
            s4 = items.get(position).getPayMentNum();
        }else
            s4 = "없음";

        holder.tvPayHistory.setText("가격 :"+s1+"\n"+"카드 넘버 :"+s2+"\n"+"할부개월 :"+s3+"\n"+"결제 넘버 :"+s4+"\n");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<PayHistory> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
