package com.gchulsong.example.wrapcontentableswiperefreshlayout.example

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import com.gchulsong.example.wrapcontentableswiperefreshlayout.R
import kotlinx.android.synthetic.main.activity_example_listview.*

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

class ListViewActivity : AppCompatActivity() {

    private var arrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_listview)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE

        back.setOnClickListener {
            finish()
        }

        wapcontentable_swiperefreshlayout.setOnRefreshListener {
            Handler().postDelayed({ wapcontentable_swiperefreshlayout.isRefreshing = false }, 1000)
        }

        arrayAdapter = ArrayAdapter(this, R.layout.view_adapterview_item, R.id.item_text)
        listview.adapter = arrayAdapter

        arrayAdapter?.add("ListView Row 1")
        arrayAdapter?.add("ListView Row 2")
        arrayAdapter?.add("ListView Row 3")
        arrayAdapter?.add("ListView Row 4")

        Handler().postDelayed({
            wapcontentable_swiperefreshlayout.visibility = View.VISIBLE
            wapcontentable_swiperefreshlayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.view_enter_from_bottom))
        }, 500)
    }
}
