package com.example.fintech.ui.goods;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.data.vo.Goods;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Goods extends RecyclerView.Adapter<Adapter_Goods.ViewHolder> {
    private ArrayList<Goods> items;

    public Adapter_Goods() {
        this.items = new ArrayList<>();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName,tvPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_goods_name);
            tvPrice = itemView.findViewById(R.id.item_goods_price);
            ivImage = itemView.findViewById(R.id.item_img);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getGoods_name());
        holder.tvName.setTag(items.get(position).getId());
         holder.tvPrice.setTag(items.get(position).getGoods_price());
        Picasso.get()
                .load(items.get(position).getGoods_image())
                .error(R.drawable.ic_logo)
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Goods> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
