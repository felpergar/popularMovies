package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.common.getSafeResult
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.TvSeriesDataSource
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import javax.inject.Inject

class TvSeriesRemoteDataSource @Inject constructor() : TvSeriesDataSource {

  @Inject lateinit var api: TvSeriesApi

  override suspend fun getPopularTvSeries(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    getSafeResult { api.getPopularTvSeries(params.language, params.page).transformToDomain() }

  override suspend fun getTvSerieInfo(params: GetTvSerieInfoParams): ResultWrapper<TvSerieInfo> =
    getSafeResult { api.getTvSerieInfo(params.id, params.language).transformToDomain() }
}