package com.felipe.popularTvSeries.mobile.common

import androidx.recyclerview.widget.RecyclerView

class PaginationListener(
  private val onLoadMore: () -> Unit
) : RecyclerView.OnScrollListener() {

  private val visibleThreshold = 3 // The minimum amount of items to have below your current scroll position before loading more.
  private var firstVisibleItem = 0
  private var visibleItemCount = 0
  private var totalItemCount = 0
  private val FIRST_VALID_POSITION = 0

  private lateinit var recyclerViewPositionHelper: RecyclerViewPositionHelper

  override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)

    recyclerViewPositionHelper = RecyclerViewPositionHelper.createHelper(recyclerView)
    visibleItemCount = recyclerView.childCount
    totalItemCount = recyclerViewPositionHelper.itemCount
    firstVisibleItem = recyclerViewPositionHelper.findFirstVisibleItemPosition()

    if (totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold && firstVisibleItem >= FIRST_VALID_POSITION)
      onLoadMore.invoke()
  }
}
