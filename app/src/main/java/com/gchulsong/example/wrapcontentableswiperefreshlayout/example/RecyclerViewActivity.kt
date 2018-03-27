package com.gchulsong.example.wrapcontentableswiperefreshlayout.example

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.gchulsong.example.wrapcontentableswiperefreshlayout.R
import kotlinx.android.synthetic.main.activity_example_recyclerview.*
import java.util.*

/**
 * Created by 'g-chul.song@navercorp.com' on 2018-03-26.
 */

class RecyclerViewActivity : AppCompatActivity() {

    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_recyclerview)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE

        back.setOnClickListener {
            finish()
        }

        wapcontentable_swiperefreshlayout.setOnRefreshListener {
            Handler().postDelayed({ wapcontentable_swiperefreshlayout.isRefreshing = false }, 1000)
        }

        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewAdapter?.addItem("RecyclerView Row 1")
        recyclerViewAdapter?.addItem("RecyclerView Row 2")
        recyclerViewAdapter?.addItem("RecyclerView Row 3")
        recyclerViewAdapter?.addItem("RecyclerView Row 4")
        recyclerViewAdapter?.addItem("RecyclerView Row 5")

        Handler().postDelayed({
            wapcontentable_swiperefreshlayout.visibility = View.VISIBLE
            wapcontentable_swiperefreshlayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.view_enter_from_bottom))
        }, 500)
    }

    private inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ExampleViewHolder>() {

        private val itemTextList: MutableList<String>

        init {
            itemTextList = ArrayList()
        }

        inner class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var itemText: TextView

            init {
                itemText = view.findViewById(R.id.item_text)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
            return ExampleViewHolder(LayoutInflater.from(this@RecyclerViewActivity).inflate(R.layout.view_adapterview_item, parent, false))
        }

        override fun onBindViewHolder(exampleViewHolder: ExampleViewHolder, position: Int) {
            exampleViewHolder.itemText.text = itemTextList[position]
        }

        override fun getItemCount(): Int {
            return itemTextList.size
        }

        fun addItem(string: String) {
            itemTextList.add(string)
        }
    }
}
