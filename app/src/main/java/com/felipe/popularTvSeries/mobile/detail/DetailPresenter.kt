package com.felipe.popularTvSeries.mobile.detail

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import com.felipe.popularTvSeries.mobile.common.Presenter
import com.felipe.popularTvSeries.mobile.detail.model.TvSerieInfoViewEntity
import com.felipe.popularTvSeries.mobile.detail.model.transformToViewEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailPresenter @Inject constructor(
  private val view: DetailActivity,
  private val getTvSerieInfo: GetTvSerieInfo
) : Presenter<DetailPresenter.DetailView>() {

  private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main

  override fun onViewAttached() {
    launch { getInfo() }
  }

  private suspend fun getInfo() {
    withContext(mainDispatcher) { getView().showLoading() }
    when (val result = getTvSerieInfo.buildAsync(GetTvSerieInfoParams(view.id))) {
      is ResultWrapper.Success -> withContext(mainDispatcher) { getView().showInfo(result.data.transformToViewEntity()) }
      is ResultWrapper.Error -> println("TV SERIES: ${result.throwable.message}")
    }
    withContext(mainDispatcher) { getView().hideLoading() }
  }

  interface DetailView : View {
    fun showError()
    fun showInfo(info: TvSerieInfoViewEntity)
  }
}