package com.example.fintech.data.vo;

import com.google.gson.annotations.SerializedName;

public class MemberShip {
    @SerializedName("_id")
    private String id;

    @SerializedName("pwd")
    private String pwd;

    @SerializedName("atoken")
    private String atoken;

    @SerializedName("rtoken")
    private String rtoken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAtoken() {
        return atoken;
    }

    public void setAtoken(String atoken) {
        this.atoken = atoken;
    }

    public String getRtoken() {
        return rtoken;
    }

    public void setRtoken(String rtoken) {
        this.rtoken = rtoken;
    }
}
