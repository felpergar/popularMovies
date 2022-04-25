package com.felipe.popularTvSeries.domain.tvseries.usecase

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.UseCaseAsync
import com.felipe.popularTvSeries.domain.tvseries.TvSeriesRepository
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import javax.inject.Inject

class GetPopularTvSeries @Inject constructor(): UseCaseAsync<GetPopularTvSeriesParams, List<TvSerie>> {

  @Inject lateinit var repository: TvSeriesRepository

  override suspend fun buildAsync(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    repository.getPopularMovies(params)
}

class GetPopularTvSeriesParams(val page: Int, val isConnected: Boolean)