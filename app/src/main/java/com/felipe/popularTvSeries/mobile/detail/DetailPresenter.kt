package com.felipe.popularTvSeries.mobile.detail

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import com.felipe.popularTvSeries.mobile.common.Presenter
import com.felipe.popularTvSeries.mobile.detail.model.TvSerieInfoViewEntity
import com.felipe.popularTvSeries.mobile.detail.model.transformToViewEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailPresenter @Inject constructor(
  private val getTvSerieInfo: GetTvSerieInfo
) : Presenter<DetailPresenter.DetailView>() {

  private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main

  override fun onViewAttached() {
    getView().onViewInit()
  }

  fun initProcess(id: Int, language: String) {
    launch { getInfo(id, language) }
  }
  private suspend fun getInfo(id: Int, language: String) {
    getView().showLoading()
    when (val result = getTvSerieInfo.buildAsync(GetTvSerieInfoParams(id, language))) {
      is ResultWrapper.Success -> withContext(mainDispatcher) { getView().showInfo(result.data.transformToViewEntity()) }
      is ResultWrapper.Error -> println("TV SERIES: ${result.throwable.message}")
    }
    getView().hideLoading()

  }

  interface DetailView : View {
    fun onViewInit()
    fun showError()
    fun showInfo(info: TvSerieInfoViewEntity)
  }
}

private const val LANGUAGE = "en-US"