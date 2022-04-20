package com.felipe.popularTvSeries.domain.movies

import com.felipe.popularTvSeries.data.common.ResultWrapper
import com.felipe.popularTvSeries.domain.movies.model.TvSerie
import com.felipe.popularTvSeries.domain.movies.usecase.GetPopularTvSeriesParams
import dagger.Provides

interface TvSeriesRepository {

  suspend fun getPopularMovies(params: GetPopularTvSeriesParams): ResultWrapper<List<TvSerie>>
}