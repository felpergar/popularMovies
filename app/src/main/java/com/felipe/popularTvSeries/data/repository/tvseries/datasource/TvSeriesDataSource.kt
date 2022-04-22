package com.felipe.popularTvSeries.data.repository.tvseries.datasource

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams

interface TvSeriesDataSource {

  suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>>
}