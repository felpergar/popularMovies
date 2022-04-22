package com.felipe.popularTvSeries.data.repository.tvseries

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesRemoteDataSource
import com.felipe.popularTvSeries.domain.tvseries.TvSeriesRepository
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import javax.inject.Inject

class TvSeriesDataRepository @Inject constructor() : TvSeriesRepository {

  @Inject lateinit var remoteDataSource: TvSeriesRemoteDataSource

  override suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    remoteDataSource.getPopularMovies(params)
}