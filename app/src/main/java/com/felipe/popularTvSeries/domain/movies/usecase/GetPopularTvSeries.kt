package com.felipe.popularTvSeries.domain.movies.usecase

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.UseCaseAsync
import com.felipe.popularTvSeries.domain.movies.TvSeriesRepository
import com.felipe.popularTvSeries.domain.movies.model.TvSerie
import javax.inject.Inject

class GetPopularTvSeries @Inject constructor(): UseCaseAsync<GetPopularTvSeriesParams, List<TvSerie>> {

  @Inject lateinit var repository: TvSeriesRepository

  override suspend fun buildAsync(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    repository.getPopularMovies(params)
}

class GetPopularTvSeriesParams(val language: String, val page: Int)