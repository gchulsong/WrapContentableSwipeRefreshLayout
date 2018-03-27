package com.gchulsong.example.wrapcontentableswiperefreshlayout.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.gchulsong.example.wrapcontentableswiperefreshlayout.R;
import com.gchulsong.wrapcontentableswiperefreshlayout.WrapContentableSwipeRefreshLayout;

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

public class ScrollViewActivity extends AppCompatActivity {

    private View back;
    private ViewGroup slot;
    private LayoutInflater layoutInflater;
    private WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_scrollview);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        wrapContentableSwipeRefreshLayout = findViewById(R.id.wapcontentable_swiperefreshlayout);
        wrapContentableSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wrapContentableSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        layoutInflater = LayoutInflater.from(this);
        slot = findViewById(R.id.slot);

        for (int index = 0; index < 3; index++) {
            View view = layoutInflater.inflate(R.layout.view_adapterview_item, slot, false);
            ((TextView) view.findViewById(R.id.item_text)).setText("ViewGroup Row " + (index + 1));
            slot.addView(view);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wrapContentableSwipeRefreshLayout.setVisibility(View.VISIBLE);
                wrapContentableSwipeRefreshLayout.startAnimation(AnimationUtils.loadAnimation(ScrollViewActivity.this, R.anim.view_enter_from_bottom));
            }
        }, 300);
    }
}
