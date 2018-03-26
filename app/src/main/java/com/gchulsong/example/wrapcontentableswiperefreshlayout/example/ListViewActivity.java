package com.gchulsong.example.wrapcontentableswiperefreshlayout.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gchulsong.example.wrapcontentableswiperefreshlayout.R;
import com.gchulsong.wrapcontentableswiperefreshlayout.WrapContentableSwipeRefreshLayout;

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

public class ListViewActivity extends AppCompatActivity {

    private View back;
    private ListView listView;
    private WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_listview);

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

        arrayAdapter = new ArrayAdapter<>(this, R.layout.view_adapterview_item, R.id.item_text);

        listView = findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);

        arrayAdapter.add("ListView Row 1");
        arrayAdapter.add("ListView Row 2");
        arrayAdapter.add("ListView Row 3");
        arrayAdapter.add("ListView Row 4");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wrapContentableSwipeRefreshLayout.setVisibility(View.VISIBLE);
                wrapContentableSwipeRefreshLayout.startAnimation(AnimationUtils.loadAnimation(ListViewActivity.this, R.anim.view_enter_from_bottom));
            }
        }, 300);
    }
}
