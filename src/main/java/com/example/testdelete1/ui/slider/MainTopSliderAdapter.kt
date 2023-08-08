package com.example.testdelete1.ui.slider

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.example.testdelete1.R
import com.example.testdelete1.models.BooksBanner
import com.opensooq.pluto.base.PlutoAdapter
import com.opensooq.pluto.base.PlutoViewHolder
import com.opensooq.pluto.listeners.OnItemClickListener

class MainTopSliderAdapter(items: MutableList<BooksBanner>, onItemClickListener: OnItemClickListener<BooksBanner>)
    : PlutoAdapter<BooksBanner, MainTopSliderAdapter.ViewHolder>(items, onItemClickListener) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent, R.layout.home_slider)
    }

    class ViewHolder(parent: ViewGroup, itemLayoutId: Int) : PlutoViewHolder<BooksBanner>(parent, itemLayoutId) {
        private var ivPoster: ImageView = getView(R.id.iv_poster)
        private var tvRating: TextView = getView(R.id.tv_rating)

        override fun set(item: BooksBanner, position: Int) {
            Glide.with(context).load(item.posterId).into(ivPoster)
            tvRating.text = item.imdbRating
        }
    }
}