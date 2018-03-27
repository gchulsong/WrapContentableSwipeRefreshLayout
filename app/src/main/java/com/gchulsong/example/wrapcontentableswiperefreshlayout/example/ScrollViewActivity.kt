package com.gchulsong.example.wrapcontentableswiperefreshlayout.example

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.gchulsong.example.wrapcontentableswiperefreshlayout.R
import kotlinx.android.synthetic.main.activity_example_scrollview.*

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

class ScrollViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_scrollview)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE

        back.setOnClickListener {
            finish()
        }

        wapcontentable_swiperefreshlayout.setOnRefreshListener {
            Handler().postDelayed({wapcontentable_swiperefreshlayout?.isRefreshing = false},1000)
        }

        for (index in 1..3) {
            val view = LayoutInflater.from(this).inflate(R.layout.view_adapterview_item, slot, false)
            (view.findViewById<View>(R.id.item_text) as TextView).text = "ViewGroup Row " + index
            slot.addView(view)
        }

        Handler().postDelayed({
            wapcontentable_swiperefreshlayout.visibility = View.VISIBLE
            wapcontentable_swiperefreshlayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.view_enter_from_bottom))
        }, 500)
    }
}
