package com.gchulsong.example.wrapcontentableswiperefreshlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.gchulsong.example.wrapcontentableswiperefreshlayout.example.ListViewActivity;
import com.gchulsong.example.wrapcontentableswiperefreshlayout.example.RecyclerViewActivity;
import com.gchulsong.example.wrapcontentableswiperefreshlayout.example.ScrollViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);

        findViewById(R.id.button_scrollview_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScrollViewActivity.class));
            }
        });

        findViewById(R.id.button_listview_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
            }
        });

        findViewById(R.id.button_recyclerview_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });
    }
}
