package com.felipe.popularTvSeries.mobile.common

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.load(url: String?) {
  Glide.with(this).load("$BASE_URL$url").into(this)
}

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(this, text, duration).show()
}

private const val BASE_URL = "https://image.tmdb.org/t/p/w300"