package com.xinheng.leftslidedeleterecycleview

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by XinHeng on 2019/03/11.
 * describe：仅标题滑动适配器
 */
class TitleSlideAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item_title_slide,
                parent,
                false
            )
        ) {}
        else object : RecyclerView.ViewHolder(ImageView(parent.context).apply {
            setImageResource(R.mipmap.ic_launcher)
        }) {}
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}