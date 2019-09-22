package com.example.testtask.presentation.screen.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.presentation.common.inflate
import com.example.testtask.presentation.common.loadGlideImgId
import com.example.testtask.presentation.model.NewsItem
import kotlinx.android.synthetic.main.item.view.*

class NewsAdapter(private val loadNews: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object{
        const val NEWS_POST = 1
        const val REPEAT_BUTTON = 2
    }

    private var news: MutableList<NewsItem> = mutableListOf()
    private var isRepeat = false
    private lateinit var onClickRepeat: (RepeatHolder) -> Unit

    override fun getItemViewType(position: Int): Int {
        return if (position == news.size - 1 && isRepeat) {
            REPEAT_BUTTON
        } else {
            NEWS_POST
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType){
        NEWS_POST -> NewsHolder(
            parent.inflate(R.layout.item)
        )
        REPEAT_BUTTON -> RepeatHolder(
            parent.inflate(R.layout.item_repeat_button)
        )
        else -> throw IllegalArgumentException("viewType: $viewType is not found")
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (news.size - position == 20)
            loadNews()

        when(holder){
            is NewsHolder -> holder.bind(news[position])
            is RepeatHolder -> initListener(holder)
        }
    }

    private fun initListener(holder: RepeatHolder){
        if (::onClickRepeat.isInitialized) {
            holder.addOnClickListener(onClickRepeat)
        }
    }

    fun addOnClickRepeat(consumer: (RepeatHolder) -> Unit) {
        onClickRepeat = consumer
    }

    fun showRepeatButton(){
        isRepeat = true
        notifyDataSetChanged()
    }

    fun setNews(news: List<NewsItem>){
        this.news.clear()
        isRepeat = false
        this.news.addAll(news)
        notifyDataSetChanged()
    }
}