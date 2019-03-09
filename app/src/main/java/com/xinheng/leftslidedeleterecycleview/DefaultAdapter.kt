package com.xinheng.leftslidedeleterecycleview

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

/**
 * Created by XinHeng on 2019/03/09.
 * describe：
 */
class DefaultAdapter : ItemSlideAdapter<ItemSlideAdapter.ContentViewHolder, ItemSlideAdapter.MenuViewHolder>() {
    private var context: Context? = null
    private var toast: Toast? = null
    override fun getMenuViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        if (null == context) {
            context = parent.context.applicationContext
        }
        var inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            2 -> DefaultMenuHolder(inflater.inflate(R.layout.layout_menu, parent, false)).apply {
                tvDelete.setOnClickListener(onClickDelete)
            }
            1 -> DefaultMenuHolder2(inflater.inflate(R.layout.layout_menu_2, parent, false)).apply {
                tvDelete.setOnClickListener(onClickDelete)
                tvSave.setOnClickListener(onClickSave)
            }
            else -> DefaultMenuHolder3(inflater.inflate(R.layout.layout_menu_3, parent, false)).apply {
                tvDelete.setOnClickListener(onClickDelete)
                tvSave.setOnClickListener(onClickSave)
                tvLook.setOnClickListener(onClickLook)
            }
        }
    }

    override fun getContentViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> DefaultContentHolder(inflater.inflate(R.layout.layout_item_slide, parent, false)).apply {
                tv.setOnClickListener(onClickContent)
            }
            1 -> DefaultContentHolder2(inflater.inflate(R.layout.layout_item_slide_2, parent, false)).apply {
                tv1.setOnClickListener(onClickContent)
                tv2.setOnClickListener(onClickContent)
            }
            else -> DefaultContentHolder3(inflater.inflate(R.layout.layout_item_slide_3, parent, false)).apply {
                tv1.setOnClickListener(onClickContent)
                tv2.setOnClickListener(onClickContent)
                tv3.setOnClickListener(onClickContent)
            }
        }
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    override fun onBindHolder(contentViewHolder: ContentViewHolder, menuViewHolder: MenuViewHolder,position: Int) {
        when (contentViewHolder) {
            is DefaultContentHolder -> {
                val s = "啦啦啦 $position"
                contentViewHolder.tv.tag = s
                contentViewHolder.tv.text = s
            }
            is DefaultContentHolder2 -> {
                val s = "啦啦啦 $position"
                val s1 = "哈哈哈 $position"
                contentViewHolder.tv1.tag = s
                contentViewHolder.tv1.text = s
                contentViewHolder.tv2.tag = s1
                contentViewHolder.tv2.text = s1
            }
            is DefaultContentHolder3->{
                val s = "啦啦啦 $position"
                val s1 = "哈哈哈 $position"
                val s2 = "嘿嘿嘿 $position"
                contentViewHolder.tv1.tag = s
                contentViewHolder.tv1.text = s
                contentViewHolder.tv2.tag = s1
                contentViewHolder.tv2.text = s1
                contentViewHolder.tv3.tag = s2
                contentViewHolder.tv3.text = s2
            }
        }
        when (menuViewHolder) {
            is DefaultMenuHolder -> menuViewHolder.tvDelete.tag = position
            is DefaultMenuHolder2 -> {
                menuViewHolder.tvDelete.tag = position
                menuViewHolder.tvSave.tag = position
            }
            is DefaultMenuHolder3 -> {
                menuViewHolder.tvDelete.tag = position
                menuViewHolder.tvSave.tag = position
                menuViewHolder.tvLook.tag = position
            }
        }
    }

    private val onClickContent = View.OnClickListener {
        if (it.tag is String) {
            var position: String = it.tag as String
            toast("内容点击: - $position")
        }
    }
    private val onClickDelete = View.OnClickListener {
        if (it.tag is Int) {
            var position: Int = it.tag as Int
            toast("菜单删除点击 - $position")
        }
    }
    private val onClickSave = View.OnClickListener {
        if (it.tag is Int) {
            var position: Int = it.tag as Int
            toast("菜单保存点击 - $position")
        }
    }
    private val onClickLook = View.OnClickListener {
        if (it.tag is Int) {
            var position: Int = it.tag as Int
            toast("菜单查看点击 - $position")
        }
    }

    private fun toast(s: String) {
        onDefaultClickListener?.click()
        if (null == toast) {
            toast = Toast.makeText(context!!, "内容点击", Toast.LENGTH_SHORT)
            toast!!.setGravity(Gravity.CENTER, 0, 0)
        }
        toast?.setText(s)
        toast?.show()
    }

    class DefaultContentHolder(view: View) : ItemSlideAdapter.ContentViewHolder(view) {
        var tv = view.findViewById<TextView>(R.id.tv_content1)!!
    }

    class DefaultMenuHolder(view: View) : ItemSlideAdapter.MenuViewHolder(view) {
        var tvDelete = view.findViewById<TextView>(R.id.tv_delete)!!
    }

    class DefaultContentHolder2(view: View) : ItemSlideAdapter.ContentViewHolder(view) {
        var tv1 = view.findViewById<TextView>(R.id.tv_content1)!!
        var tv2 = view.findViewById<TextView>(R.id.tv_content2)!!
    }
    class DefaultContentHolder3(view: View) : ItemSlideAdapter.ContentViewHolder(view) {
        var tv1 = view.findViewById<TextView>(R.id.tv_content1)!!
        var tv2 = view.findViewById<TextView>(R.id.tv_content2)!!
        var tv3 = view.findViewById<TextView>(R.id.tv_content3)!!
    }
    class DefaultMenuHolder2(view: View) : ItemSlideAdapter.MenuViewHolder(view) {
        var tvDelete = view.findViewById<TextView>(R.id.tv_delete)!!
        var tvSave = view.findViewById<TextView>(R.id.tv_save)!!
    }

    class DefaultMenuHolder3(view: View) : ItemSlideAdapter.MenuViewHolder(view) {
        var tvDelete = view.findViewById<TextView>(R.id.tv_delete)!!
        var tvSave = view.findViewById<TextView>(R.id.tv_save)!!
        var tvLook = view.findViewById<TextView>(R.id.tv_look)!!
    }
    var onDefaultClickListener:OnDefaultClickListener?=null
    interface OnDefaultClickListener{
        fun click()
    }
}