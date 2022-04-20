package com.felipe.popularTvSeries.mobile.mainView

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.movies.usecase.GetPopularTvSeries
import com.felipe.popularTvSeries.domain.movies.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.mobile.common.Presenter
import com.felipe.popularTvSeries.mobile.mainView.model.transformToViewEntity
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
  private val getTvSeries: GetPopularTvSeries
) : Presenter<MainPresenter.MainView>() {

  override fun onViewAttached() {
    launch {
      val params = GetPopularTvSeriesParams("en-US", 1)
      when(val result = getTvSeries.buildAsync(params)) {
        is ResultWrapper.Success -> println("TV SERIES: ${result.data.transformToViewEntity().size}")
        is ResultWrapper.Error -> println("TV SERIES: ${result.throwable.message}")
      }
    }
  }

  interface MainView : View {
  }
}