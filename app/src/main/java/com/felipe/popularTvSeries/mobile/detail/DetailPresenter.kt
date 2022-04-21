package com.felipe.popularTvSeries.mobile.detail

import com.felipe.popularTvSeries.mobile.common.Presenter
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity

class DetailPresenter(private val tvSerieInfo: TvSerieViewEntity?) : Presenter<DetailPresenter.DetailView>() {

  override fun onViewAttached() {  //This could be improve getting data from server with a get detail call
    if(tvSerieInfo == null) getView().showError()
    else getView().showInfo(tvSerieInfo)
  }

  interface DetailView : View {
    fun showError()
    fun showInfo(info: TvSerieViewEntity)
  }
}