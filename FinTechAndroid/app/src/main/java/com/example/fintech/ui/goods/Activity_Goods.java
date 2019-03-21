package com.example.fintech.ui.goods;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    @BindView(R.id.rv_goods) RecyclerView rvGoods;
    @BindView(R.id.goods_tab) TabLayout mTabLayout;

    private BaseActivity mContext;
    private Presenter_Goods mPresenter;
    private Adapter_Goods mAdapter;
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
        setTab();
        setRecyclerView();
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
        ((TextView)CustomView.findViewById(R.id.toolbar_title)).setText("전체 메뉴");
        setUpToolbar(CustomView);

        //Recycler Touch 이벤트
        RvItemTouchListener itemTouchListener = new RvItemTouchListener(mContext,rvGoods) {
            @Override
            public boolean ItemEvent(RecyclerView recyclerView, GestureDetector gestureDetector, MotionEvent motionEvent, Activity activity) {
                View childView = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());

                if(childView != null && gestureDetector.onTouchEvent(motionEvent)){
                    String id = (String) childView.findViewById(R.id.item_goods_name).getTag();
                    CommonUtils.GoToActivity(activity,id,Activity_GoodsDetail.class);
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
                        mPresenter.NetworkingGetCoffeeList(mContext,mAdapter);
                        break;
                    case 1:
                        mPresenter.NetworkingGetFoodList(mContext,mAdapter);
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
    }

    @Override
    public void onClick(View v) {
        mPresenter.MenuBackClickEvent(mContext);
    }
}
