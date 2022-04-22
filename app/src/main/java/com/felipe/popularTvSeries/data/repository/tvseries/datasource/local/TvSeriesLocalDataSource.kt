package com.felipe.popularTvSeries.data.repository.tvseries.datasource.local

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.TvSeriesDataSource
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams
import javax.inject.Inject

class TvSeriesLocalDataSource @Inject constructor(val dao: TvSerieDao): TvSeriesDataSource {

  override suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>> {
    TODO("Not yet implemented")
  }
}