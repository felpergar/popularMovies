package com.felipe.popularTvSeries.domain.tvseries.usecase

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.UseCaseAsync
import com.felipe.popularTvSeries.domain.tvseries.TvSeriesRepository
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo
import javax.inject.Inject

class GetTvSerieInfo @Inject constructor(): UseCaseAsync<GetTvSerieInfoParams, TvSerieInfo> {

  @Inject lateinit var repository: TvSeriesRepository

  override suspend fun buildAsync(params: GetTvSerieInfoParams): ResultWrapper<TvSerieInfo> =
    repository.getTvSerieInfo(params)
}

class GetTvSerieInfoParams(val id: Int, val language: String)