package com.example.testtask.presentation.screen.news.adapter

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.presentation.common.loadGlideImgId
import com.example.testtask.presentation.model.NewsItem
import kotlinx.android.synthetic.main.item.view.*

class NewsHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(news: NewsItem){
        itemView.title.text = news.title
        itemView.description.text = news.description
        itemView.publishedAt.text = news.publishedAt
        if(news.urlToImage.isNullOrEmpty())
            Glide.with(itemView).load(R.drawable.nophoto).into(itemView.img)
        else
            itemView.img.loadGlideImgId(news.urlToImage)

        itemView.setOnClickListener {
            itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(news.url)))
        }
    }

}