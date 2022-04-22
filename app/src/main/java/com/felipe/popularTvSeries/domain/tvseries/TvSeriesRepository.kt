package com.felipe.popularTvSeries.domain.tvseries

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.usecase.GetPopularTvSeriesParams

interface TvSeriesRepository {

  suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>>
}