package com.felipe.popularTvSeries.data.repository.tvseries

import android.content.Context
import android.net.ConnectivityManager
import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.TvSeriesLocalDataSource
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesRemoteDataSource
import com.felipe.popularTvSeries.domain.tvseries.TvSeriesRepository
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TvSeriesDataRepository @Inject constructor(@ApplicationContext private val context: Context) : TvSeriesRepository {

  @Inject lateinit var remoteDataSource: TvSeriesRemoteDataSource
  @Inject lateinit var localDataSource: TvSeriesLocalDataSource

  override suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> {
    return if (isConnected()) getFromApi(params)
    else localDataSource.getPopularTvSeries(params)
  }

  private suspend fun getFromApi(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> {
    val result = remoteDataSource.getPopularTvSeries(params)
    return if(result is ResultWrapper.Success) {
      localDataSource.deleteAllDataBase()
      localDataSource.savePopularTvSeries(result.data)
      result
    }
    else localDataSource.getPopularTvSeries(params)
  }

  override suspend fun getTvSerieInfo(params: GetTvSerieInfoParams): ResultWrapper<TvSerieInfo> {
    return localDataSource.getTvSerieInfo(params)
//    return if (isConnected()) remoteDataSource.getTvSerieInfo(params) else localDataSource.getTvSerieInfo(params) //Finally I don´t execute this code because it isn´t work the endpoint
  }

  private fun isConnected(): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    val connectionState=  activeNetwork != null && activeNetwork.isConnectedOrConnecting
    println("Connection: $connectionState")
    return connectionState
  }
}
