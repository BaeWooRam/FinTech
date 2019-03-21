package com.example.fintech.data.vo;

import com.google.gson.annotations.SerializedName;

public class Goods {
    @SerializedName("id")
    private String id;

    @SerializedName("goods_name")
    private String Goods_name;

    @SerializedName("goods_price")
    private String Goods_price;

    @SerializedName("goods_image")
    private String Goods_image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_name() {
        return Goods_name;
    }

    public void setGoods_name(String goods_name) {
        Goods_name = goods_name;
    }

    public String getGoods_price() {
        return Goods_price;
    }

    public void setGoods_price(String goods_price) {
        Goods_price = goods_price;
    }

    public String getGoods_image() {
        return Goods_image;
    }

    public void setGoods_image(String goods_image) {
        Goods_image = goods_image;
    }
}
