package com.felipe.popularTvSeries.mobile.mainView

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.movies.usecase.GetPopularTvSeries
import com.felipe.popularTvSeries.domain.movies.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.mobile.common.Presenter
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.popularTvSeries.mobile.mainView.model.transformToViewEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainPresenter @Inject constructor(
  private val getTvSeries: GetPopularTvSeries,
) : Presenter<MainPresenter.MainView>() {

  private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main

  override fun onViewAttached() {
    getView().initRecyclerView()
    launch { getTvSeries() }
  }

  private suspend fun getTvSeries() {
    withContext(mainDispatcher) { getView().showLoading() }
    val params = GetPopularTvSeriesParams("en-US", 1)
    when (val result = getTvSeries.buildAsync(params)) {
      is ResultWrapper.Success -> {
        withContext(mainDispatcher) { getView().showItems(result.data.transformToViewEntity()) }
      }
      is ResultWrapper.Error -> println("TV SERIES: ${result.throwable.message}")
    }
    withContext(mainDispatcher) { getView().hideLoading() }
  }

  interface MainView : View {
    fun showItems(tvSeries: List<TvSerieViewEntity>)
    fun initRecyclerView()
  }
}