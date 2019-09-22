package com.example.testtask.presentation.common

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.presentation.converter.PresentationConverter
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadGlideImgId(resId: String) =
    Glide.with(this)
        .load(resId)
        .fallback(R.drawable.nophoto)
        .into(this)

fun View.showSnackbar(
    string: String,
    @ColorInt colorId: Int = Color.WHITE,
    length: Int = Snackbar.LENGTH_LONG) {

    val snack = Snackbar.make(this, string, length)
    val tv = snack.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    tv.setTextColor(colorId)
    snack.show()
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context)
        .inflate(layoutId, this, attachToRoot)