package com.gchulsong.example.wrapcontentableswiperefreshlayout.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.gchulsong.example.wrapcontentableswiperefreshlayout.R;
import com.gchulsong.wrapcontentableswiperefreshlayout.WrapContentableSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    private View back;
    private RecyclerView recyclerView;
    private LayoutInflater layoutInflater;
    private WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_recyclerview);

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
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerViewAdapter.addItem("RecyclerView Row 1");
        recyclerViewAdapter.addItem("RecyclerView Row 2");
        recyclerViewAdapter.addItem("RecyclerView Row 3");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wrapContentableSwipeRefreshLayout.setVisibility(View.VISIBLE);
                wrapContentableSwipeRefreshLayout.startAnimation(AnimationUtils.loadAnimation(RecyclerViewActivity.this, R.anim.view_enter_from_bottom));
            }
        }, 300);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ExampleViewHolder> {

        private List<String> itemTextList;

        public RecyclerViewAdapter() {
            itemTextList = new ArrayList<>();
        }

        public class ExampleViewHolder extends RecyclerView.ViewHolder {
            public TextView itemText;

            public ExampleViewHolder(View view) {
                super(view);
                itemText = view.findViewById(R.id.item_text);
            }
        }

        @Override
        public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ExampleViewHolder(layoutInflater.inflate(R.layout.view_adapterview_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ExampleViewHolder exampleViewHolder, int position) {
            exampleViewHolder.itemText.setText(itemTextList.get(position));
        }

        @Override
        public int getItemCount() {
            return itemTextList.size();
        }

        public void addItem(String string){
            itemTextList.add(string);
        }
    }
}
