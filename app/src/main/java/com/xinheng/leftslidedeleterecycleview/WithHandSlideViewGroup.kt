package com.xinheng.leftslidedeleterecycleview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout

/**
 * Created by XinHeng on 2019/03/04.
 * describe：随手势滑动的view
 * 借助view的scrollTo方法实现向左移动
 */
class WithHandSlideViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var menuWidth: Int = 0

    private var menuWidthHalf = 0f

    init {
        orientation = HORIZONTAL
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        menuWidth = getChildAt(1).measuredWidth
        menuWidthHalf = menuWidth / 2f
    }

    private var oldX: Float = 0f
    private var oldY: Float = 0f
    private var showMenu = false
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("TAGWith", "dispatchTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("TAGWith", "dispatchTouchEvent: ACTION_MOVE")
            }
            MotionEvent.ACTION_UP -> {
                Log.e("TAGWith", "dispatchTouchEvent: ACTION_UP")
            }
        }
        var dispatchTouchEvent = super.dispatchTouchEvent(event)
        Log.e("TAGWith", "dispatchTouchEvent: $dispatchTouchEvent")
        return dispatchTouchEvent
    }
    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("TAGWith", "onInterceptTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("TAGWith", "onInterceptTouchEvent: ACTION_MOVE")
            }
            MotionEvent.ACTION_UP -> {
                Log.e("TAGWith", "onInterceptTouchEvent: ACTION_UP")
            }
        }
        var onInterceptTouchEvent = super.onInterceptTouchEvent(event)
        Log.e("TAGWith", "onInterceptTouchEvent: $onInterceptTouchEvent")
        return onInterceptTouchEvent
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.e("TAGWith", "onTouchEvent: ACTION_DOWN")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.e("TAGWith", "onTouchEvent: ACTION_MOVE")
            }
            MotionEvent.ACTION_UP -> {
                Log.e("TAGWith", "onTouchEvent: ACTION_UP")
            }
        }
        var onTouchEvent = super.onTouchEvent(event)
        Log.e("TAGWith", "onTouchEvent: $onTouchEvent")
        return onTouchEvent
    }

    private fun showMenu() {
        scrollTo(menuWidth, 0)
        showMenu = true
        if (parent is ItemSlideRecycleView) {
            (parent as ItemSlideRecycleView).showMenuView = this
        }
    }

    fun reset() {
        scrollTo(0, 0)
        showMenu = false
    }

    private fun checkOtherShowMenu() {
        if (parent is ItemSlideRecycleView) {
            var showMenuView = (parent as ItemSlideRecycleView).showMenuView
            if (this != showMenuView) {
                showMenuView?.reset()
            }
        }
    }
}