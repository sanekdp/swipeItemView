package com.example.library.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;


public class SwipeItemView extends FrameLayout implements GestureDetector.OnGestureListener {


    private GestureDetectorCompat mGestureDetectorCompat;
    private View mTopView;
    private View mBottomView;


    public SwipeItemView(Context context) {
        super(context);
        mGestureDetectorCompat = new GestureDetectorCompat(getContext(), this);
    }

    public SwipeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTopView = new View((getContext()));
        mBottomView = new View((getContext()));

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        mTopView.setLayoutParams(params);
        mBottomView.setLayoutParams(params);

        ViewCompat.setBackground(mTopView, new ColorDrawable((Color.RED)));
        ViewCompat.setBackground(mBottomView, new ColorDrawable((Color.GREEN)));

        addView(mBottomView);
        addView(mTopView);


        mGestureDetectorCompat = new GestureDetectorCompat(getContext(), this);
    }

    public SwipeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SwipeItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //Log.d(SwipeItemView.class.getSimpleName(), "dispatchTouchEvent");
        mGestureDetectorCompat.onTouchEvent(ev);

        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

//        Log.d(SwipeItemView.class.getSimpleName(), motionEvent.getX() + " start " + motionEvent1.getX() + " current ");
        float diff = motionEvent1.getX() - motionEvent.getX();

        float newX = mTopView.getX() - diff;
        Log.d(SwipeItemView.class.getSimpleName(), "" + newX);

        if (motionEvent1.getX() > (mTopView.getMeasuredWidth() / 2))

            mTopView.setX(motionEvent1.getX());


        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
