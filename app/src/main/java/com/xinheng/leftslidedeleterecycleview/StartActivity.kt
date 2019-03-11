package com.xinheng.leftslidedeleterecycleview

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.content_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_start)
        tv_first.setOnClickListener {
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
        }
        tv_second.setOnClickListener {
            startActivity(Intent(this@StartActivity, Main2Activity::class.java))
        }
    }

}
