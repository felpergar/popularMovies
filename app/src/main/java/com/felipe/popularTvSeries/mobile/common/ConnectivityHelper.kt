package com.felipe.popularTvSeries.mobile.common

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class ConnectivityHelper @Inject constructor(
  @ActivityContext private val context: Context,
) {

  fun isConnected(): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    val connectionState = activeNetwork != null && activeNetwork.isConnectedOrConnecting
    println("Connection: $connectionState")
    return connectionState
  }
}
