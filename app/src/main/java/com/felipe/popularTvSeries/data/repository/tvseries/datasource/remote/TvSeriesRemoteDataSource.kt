package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.common.getSafeResult
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.TvSeriesDataSource
import com.felipe.popularTvSeries.domain.movies.model.TvSerie
import com.felipe.popularTvSeries.domain.movies.usecase.GetPopularTvSeriesParams
import javax.inject.Inject

class TvSeriesRemoteDataSource @Inject constructor() : TvSeriesDataSource {

  @Inject lateinit var api: TvSeriesApi

  override suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    getSafeResult { api.getPopularTvSeries(params.language, params.count).transformToDomain() }
}