package com.example.fintech.ui.goods;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fintech.R;
import com.example.fintech.base.BaseActivity;
import com.example.fintech.ui.goods.detail.Activity_GoodsDetail;
import com.example.fintech.util.CommonUtils;
import com.example.fintech.util.RecyclerCreateLineUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Goods extends BaseActivity implements Contract_Goods.mvpView, View.OnClickListener {
    public static int CATEGORY_BERVERAGE = 0;
    public static int CATEGORY_FOOD = 1;
    public static String INTEND_NAME = "info";
    public static int INTEND_POSTION_ID = 0;
    public static int INTEND_POSTION_CATEGORY = 1;

    @BindView(R.id.rv_goods) RecyclerView rvGoods;
    @BindView(R.id.tab_goods) TabLayout mTabLayout;

    private BaseActivity mContext;
    private Presenter_Goods mPresenter;
    private Adapter_Goods mAdapter;
    private int mCurrnetCategory=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);

        SetUp();
    }

    @Override
    public void SetUp() {
        mContext = this;
        setPresenter();
        setRecyclerView();
        setTab();
        InitActivity();

    }

    @Override
    public void setPresenter() {
        mPresenter = new Presenter_Goods();
    }

    @Override
    public void InitActivity() {
        //toolbar 세팅
        View CustomView = View.inflate(mContext, R.layout.toolbar,null);
        ((ImageButton)CustomView.findViewById(R.id.btnBack)).setOnClickListener(this);
        setUpToolbar(CustomView);

        //Recycler Touch 이벤트
        RvItemTouchListener itemTouchListener = new RvItemTouchListener(mContext,rvGoods) {
            @Override
            public boolean ItemEvent(RecyclerView recyclerView, GestureDetector gestureDetector, MotionEvent motionEvent, Activity activity) {
                View childView = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());

                if(childView != null && gestureDetector.onTouchEvent(motionEvent)){
                    String[] info = {(String) childView.findViewById(R.id.item_goods_name).getTag(),String.valueOf(mCurrnetCategory)};
                    CommonUtils.GoToActivity(activity,info,"info",Activity_GoodsDetail.class);
                    return true;
                }
                return false;
            }
        };
    }

    @Override
    public void setRecyclerView() {
        rvGoods.addItemDecoration(new RecyclerCreateLineUtils(4));

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        LayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvGoods.setLayoutManager(LayoutManager);
        rvGoods.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new Adapter_Goods();
        rvGoods.setAdapter(mAdapter);
    }

    @Override
    public void setTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText("음료"));
        mTabLayout.addTab(mTabLayout.newTab().setText("푸드"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int index = tab.getPosition();

                switch (index){
                    case 0:
                        mCurrnetCategory=CATEGORY_BERVERAGE;
                        mPresenter.NetworkingGetCoffeeList(mContext,mAdapter);
                        Log.e("Tab","BERVERAGE");
                        break;
                    case 1:
                        mCurrnetCategory=CATEGORY_FOOD;
                        mPresenter.NetworkingGetFoodList(mContext,mAdapter);
                        Log.e("Tab","FOOD");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mPresenter.NetworkingGetCoffeeList(mContext,mAdapter);
    }

    @Override
    public void onClick(View v) {
        mPresenter.MenuBackClickEvent(mContext);
    }
}
