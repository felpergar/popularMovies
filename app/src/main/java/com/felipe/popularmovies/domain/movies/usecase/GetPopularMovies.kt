package com.felipe.popularmovies.domain.movies.usecase

import com.felipe.popularmovies.data.common.ResultWrapper
import com.felipe.popularmovies.domain.UseCaseAsync
import com.felipe.popularmovies.domain.movies.model.Movie

class GetPopularMovies: UseCaseAsync<GetPopularMoviesParams, List<Movie>> {
  
  override suspend fun buildAsync(params: GetPopularMoviesParams): ResultWrapper<List<Movie>> {
    TODO("Not yet implemented")
  }
}

class GetPopularMoviesParams()