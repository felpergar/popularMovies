package com.felipe.popularmovies.domain.movies

interface MoviesRepository {

  suspend fun getPopularMovies()
}