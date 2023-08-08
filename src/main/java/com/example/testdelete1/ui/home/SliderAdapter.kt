package com.example.testdelete1.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.testdelete1.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter : SliderViewAdapter<SliderViewAdapter.ViewHolder>() {
    var  images = intArrayOf(
        R.drawable.banner,
        R.drawable.book,
        R.drawable.book1

    );

    fun SliderAdapter(images: IntArray) {
        this.images = images
    }
    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return Holder(view)
    }


    override fun getCount(): Int {
        return images.size
    }

    inner class Holder(itemView: View) : ViewHolder(itemView) {
        val imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.image_view)
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        viewHolder?.itemView.apply {  (images[position])}

    }
}
