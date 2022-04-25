package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.common.getSafeResult
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.TvSeriesDataSource
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import java.util.*
import javax.inject.Inject

class TvSeriesRemoteDataSource @Inject constructor(val locale: Locale) : TvSeriesDataSource {

  @Inject lateinit var api: TvSeriesApi

  override suspend fun getPopularTvSeries(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    getSafeResult { api.getPopularTvSeries(locale.toLanguageTag(), params.page).transformToDomain() }

  override suspend fun getTvSerieInfo(params: GetTvSerieInfoParams): ResultWrapper<TvSerieInfo> =
    getSafeResult { api.getTvSerieInfo(params.id, locale.toLanguageTag()).transformToDomain() }
}