package com.xinheng.leftslidedeleterecycleview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.TextView

/**
 * Created by XinHeng on 2019/03/05.
 * describe：
 */
class MyTextView : android.support.v7.widget.AppCompatTextView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("MyTextView", "dispatchTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("MyTextView", "dispatchTouchEvent: ACTION_MOVE")
            }
            MotionEvent.ACTION_UP -> {
                Log.e("MyTextView", "dispatchTouchEvent: ACTION_UP")
            }
            MotionEvent.ACTION_CANCEL -> Log.e("MyTextView", "dispatchTouchEvent: ACTION_CANCEL")
        }
        var dispatchTouchEvent = super.dispatchTouchEvent(event)
        Log.e("MyTextView", "dispatchTouchEvent: $dispatchTouchEvent")
        return dispatchTouchEvent
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("MyTextView", "onTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> Log.e("MyTextView", "onTouchEvent: ACTION_MOVE")
            MotionEvent.ACTION_UP -> Log.e("MyTextView", "onTouchEvent: ACTION_UP")
            MotionEvent.ACTION_CANCEL -> Log.e("MyTextView", "onTouchEvent: ACTION_CANCEL")
        }
        val onTouchEvent = super.onTouchEvent(event)
        Log.e("MyTextView", "onTouchEvent: $onTouchEvent")
        return onTouchEvent
    }
}
