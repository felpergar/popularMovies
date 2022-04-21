package com.felipe.popularTvSeries.mobile.detail

import com.felipe.popularTvSeries.mobile.common.Presenter

class DetailPresenter(private val id: String) : Presenter<DetailPresenter.DetailView>() {

  override fun onViewAttached() {

  }

  interface DetailView : View {
  }
}