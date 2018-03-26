package com.gchulsong.example.wrapcontentableswiperefreshlayout.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gchulsong.example.wrapcontentableswiperefreshlayout.R;
import com.gchulsong.wrapcontentableswiperefreshlayout.WrapContentableSwipeRefreshLayout;

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

public class ScrollViewActivity extends AppCompatActivity {

    private View back;
    private WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_scrollview);

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
    }
}
