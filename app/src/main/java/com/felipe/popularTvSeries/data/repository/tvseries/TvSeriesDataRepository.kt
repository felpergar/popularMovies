package com.felipe.popularTvSeries.data.repository.tvseries

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.TvSeriesLocalDataSource
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesRemoteDataSource
import com.felipe.popularTvSeries.domain.tvseries.TvSeriesRepository
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import javax.inject.Inject

class TvSeriesDataRepository @Inject constructor() : TvSeriesRepository {

  @Inject lateinit var remoteDataSource: TvSeriesRemoteDataSource
  @Inject lateinit var localDataSource: TvSeriesLocalDataSource

  override suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> {
    //    val cm = ApplicationContextModule.getSystemService(ApplicationContextModule.CONNECTIVITY_SERVICE) as ConnectivityManager
    //    ConnectivityManager.registerDefaultNetworkCallback()    ConnectivityManager.NetworkCallback()
    //    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    return if (isConnected()) getFromApi(params)
    else localDataSource.getPopularTvSeries(params)
  }

  private suspend fun getFromApi(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> {
    val result = remoteDataSource.getPopularTvSeries(params)
    return if(result is ResultWrapper.Success) {
      localDataSource.savePopularTvSeries(result.data)
      result
    }
    else localDataSource.getPopularTvSeries(params)
  }

  override suspend fun getTvSerieInfo(params: GetTvSerieInfoParams): ResultWrapper<TvSerieInfo> {
    return if (isConnected()) remoteDataSource.getTvSerieInfo(params)
    else localDataSource.getTvSerieInfo(params)
  }

  private fun isConnected(): Boolean {
    return true  //TODO add check
  }
}
