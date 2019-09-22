package com.example.testtask.presentation.screen.news.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repeat_button.view.*

class RepeatHolder(view: View): RecyclerView.ViewHolder(view) {

    fun addOnClickListener(click: (RepeatHolder) -> Unit){
        itemView.repeatButton.setOnClickListener {
            click(this)
        }
    }
}