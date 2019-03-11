package com.xinheng.leftslidedeleterecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        recycleView.layoutManager=LinearLayoutManager(this)
//        recycleView.layoutManager=GridLayoutManager(this,2)
        recycleView.onItemSlideRecycleListener = object : ItemSlideRecycleView.OnItemSlideRecycleListener {
            override fun getRealCanSlideMenuView(view: View): ViewGroup {
                return (view as ViewGroup).getChildAt(0) as ViewGroup
            }
        }
        recycleView.adapter = TitleSlideAdapter()
    }
}
