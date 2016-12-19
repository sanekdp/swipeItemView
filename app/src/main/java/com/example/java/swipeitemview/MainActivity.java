package com.example.java.swipeitemview;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.library.view.SwipeItemView;

public class MainActivity extends AppCompatActivity {

    private SwipeItemView view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (SwipeItemView) findViewById(R.id.customView);

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        view.dispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }
}
