package com.example.testtask.presentation.screen.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.presentation.common.loadGlideImgId
import com.example.testtask.presentation.model.NewsItem
import kotlinx.android.synthetic.main.item.view.*

class NewsAdapter(private val loadNews: () -> Unit): RecyclerView.Adapter<NewsHolder>(){

    private var news: MutableList<NewsItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder = NewsHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        if (news.size - position == 20)
            loadNews()

        holder.bind(news[position])
    }

    fun setNews(news: List<NewsItem>){
        this.news.clear()
        this.news.addAll(news)
        notifyDataSetChanged()
    }
}