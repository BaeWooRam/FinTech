package com.example.fintech.ui.goods;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.fintech.base.BaseActivity;

public abstract class RvItemTouchListener implements RecyclerView.OnItemTouchListener {
    private BaseActivity context;
    private GestureDetector gestureDetector;
    private RecyclerView recyclerView;

    public RvItemTouchListener(BaseActivity context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;

        gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener() {

            //누르고 뗄 때 한번만 인식하도록 하기위해서
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        recyclerView.addOnItemTouchListener(this);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        return ItemEvent(recyclerView,gestureDetector,motionEvent,context);
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
    public abstract boolean ItemEvent(RecyclerView recyclerView, GestureDetector gestureDetector, MotionEvent motionEvent, Activity activity);
}
