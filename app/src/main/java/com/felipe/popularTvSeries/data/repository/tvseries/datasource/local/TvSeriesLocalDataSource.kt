package com.felipe.popularTvSeries.data.repository.tvseries.datasource.local

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.common.getSafeResult
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.TvSeriesDataSource
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.model.transformToLocalEntity
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetTvSerieInfoParams
import com.felipe.popularTvSeries.mobile.mainView.model.transformToViewEntity
import javax.inject.Inject

class TvSeriesLocalDataSource @Inject constructor(private val dao: TvSerieDao): TvSeriesDataSource {

  override suspend fun getTvSerieInfo(params: GetTvSerieInfoParams): ResultWrapper<TvSerieInfo> =
    getSafeResult { dao.getTvSerieInfo(params.id).transformToTvSerieInfoDomain() }

  override suspend fun getPopularTvSeries(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> =
    getSafeResult { dao.getPopularTvSeries().map { it.transformToTvSerieDomain() } }

  fun savePopularTvSeries(tvSeries: List<TvSerie>) {
    dao.saveTvSeries(tvSeries.map { it.transformToLocalEntity() })
  }
}