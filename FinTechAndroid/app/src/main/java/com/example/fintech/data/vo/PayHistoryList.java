package com.example.fintech.data.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public abstract class PayHistoryList {

    @SerializedName("list")
    @Expose
    private ArrayList<PayHistory> list;

    public ArrayList<PayHistory> getList() {
        return list;
    }

    public void setList(ArrayList<PayHistory> list) {
        this.list = list;
    }
}
