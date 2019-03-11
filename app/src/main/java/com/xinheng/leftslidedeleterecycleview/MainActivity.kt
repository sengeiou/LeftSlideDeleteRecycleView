package com.xinheng.leftslidedeleterecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.layoutManager = LinearLayoutManager(this)
        //recycleView.layoutManager = GridLayoutManager(this,3)
        recycleView.addItemDecoration(
            SpaceItemDecoration(
                this,
                LinearLayoutManager.VERTICAL,
                2,
                ContextCompat.getColor(this, R.color.colorPrimary)
            )
        )
        recycleView.adapter = DefaultAdapter().apply {
            onDefaultClickListener = object : DefaultAdapter.OnDefaultClickListener {
                override fun click() {
                    recycleView.closeMenu()
                }
            }
        }
    }
}
