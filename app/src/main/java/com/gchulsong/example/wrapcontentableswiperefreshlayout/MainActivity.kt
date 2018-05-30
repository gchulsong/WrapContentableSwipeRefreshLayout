package com.gchulsong.example.wrapcontentableswiperefreshlayout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.gchulsong.example.wrapcontentableswiperefreshlayout.example.ListViewActivity
import com.gchulsong.example.wrapcontentableswiperefreshlayout.example.RecyclerViewActivity
import com.gchulsong.example.wrapcontentableswiperefreshlayout.example.ScrollViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE

        button_scrollview_example.setOnClickListener {
            startActivity(Intent(this, ScrollViewActivity::class.java))
        }

        button_listview_example.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        button_recyclerview_example.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
    // 변경1
    // 변경2
    // 변경3
}
