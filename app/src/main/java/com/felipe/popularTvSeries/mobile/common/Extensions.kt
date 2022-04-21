package com.felipe.popularTvSeries.mobile.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String?) {
  Glide.with(this).load("$BASE_URL$url").into(this)
}

private const val BASE_URL = "https://image.tmdb.org/t/p/w500"