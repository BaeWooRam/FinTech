package com.example.fintech;

import android.app.Application;

import com.example.fintech.data.vo.MemberShip;

public class FinTechApplication extends Application {
    public MemberShip getMemberInfo() {
        return MemberInfo;
    }

    public void setMemberInfo(MemberShip memberInfo) {
        MemberInfo = memberInfo;
    }

    private MemberShip MemberInfo;

}
