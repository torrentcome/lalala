package com.torrentcome.lalala.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.torrentcome.lalala.R
import com.torrentcome.lalala.domain.dto.Data
import kotlinx.android.synthetic.main.item_gif.view.*
import kotlin.properties.Delegates

class GifListAdapter(private val listener: (Data) -> Unit) :
    RecyclerView.Adapter<GifListAdapter.GifViewHolder>() {

    var list: List<Data> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder =
        GifViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gif, null)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) =
        holder.bind(list[position], listener)

    inner class GifViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bind(gif: Data, listener: (Data) -> Unit) = with(itemView) {
            title.text = gif.images.original.url.hashCode().toString()
            Glide.with(this)
                .load(gif.images.original.url)
                .apply(RequestOptions().placeholder(R.drawable.place_holder))
                .into(image)

            setOnClickListener { listener(gif) }
        }
    }
}