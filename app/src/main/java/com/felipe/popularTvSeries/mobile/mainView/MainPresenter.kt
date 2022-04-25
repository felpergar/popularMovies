package com.felipe.popularTvSeries.mobile.mainView

import android.content.Context
import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeries
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.mobile.common.ConnectivityHelper
import com.felipe.popularTvSeries.mobile.common.Presenter
import com.felipe.popularTvSeries.mobile.mainView.model.TvSerieViewEntity
import com.felipe.popularTvSeries.mobile.mainView.model.transformToViewEntity
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
  private val locale: Locale,
  private val connectivityHelper: ConnectivityHelper,
  private val getTvSeries: GetPopularTvSeries
) : Presenter<MainPresenter.MainView>() {

  private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
  private var page = FIRST_PAGE
  private var isLoading = false

  override fun onViewAttached() {
    getView().initRecyclerView()
    launch { getTvSeries() }
  }

  private suspend fun getTvSeries() {
    isLoading = true
    withContext(mainDispatcher) { getView().showLoading() }
    val params = GetPopularTvSeriesParams(page, true)
    when (val result = getTvSeries.buildAsync(params)) {
      is ResultWrapper.Success -> withContext(mainDispatcher) { getView().showItems(result.data.transformToViewEntity()) }
      is ResultWrapper.Error -> println("TV SERIES: ${result.throwable.message}")
    }
    isLoading = false
    withContext(mainDispatcher) { getView().hideLoading() }
  }

  fun onTvSerieSelected(id: Int) {
    getView().openTvSerieDetail(id)
  }

  fun onListEnded() {
    if (!isLoading && connectivityHelper.isConnected()) {
      page++
      launch { getTvSeries() }
    }
  }

  interface MainView : View {
    fun showItems(tvSeries: List<TvSerieViewEntity>)
    fun initRecyclerView()
    fun openTvSerieDetail(id: Int)
  }
}

private const val FIRST_PAGE = 1