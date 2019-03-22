package com.example.fintech.data.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PayHistory {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("trId")
    @Expose
    private String requestID;

    @SerializedName("tno")
    @Expose
    private String PayMentNum;

    @SerializedName("app_time")
    @Expose
    private String PayMentDate;

    @SerializedName("amount")
    @Expose
    private String PayMenntPrice;

    @SerializedName("installment")
    @Expose
    private String PayMentInstallment;

    @SerializedName("card_no")
    @Expose
    private String PayMentCardNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getPayMentNum() {
        return PayMentNum;
    }

    public void setPayMentNum(String payMentNum) {
        PayMentNum = payMentNum;
    }

    public String getPayMentDate() {
        return PayMentDate;
    }

    public void setPayMentDate(String payMentDate) {
        PayMentDate = payMentDate;
    }

    public String getPayMenntPrice() {
        return PayMenntPrice;
    }

    public void setPayMenntPrice(String payMenntPrice) {
        PayMenntPrice = payMenntPrice;
    }

    public String getPayMentInstallment() {
        return PayMentInstallment;
    }

    public void setPayMentInstallment(String payMentInstallment) {
        PayMentInstallment = payMentInstallment;
    }

    public String getPayMentCardNo() {
        return PayMentCardNo;
    }

    public void setPayMentCardNo(String payMentCardNo) {
        PayMentCardNo = payMentCardNo;
    }
}
