package com.felipe.popularmovies.data.repository.movies.datasource.remote

import com.felipe.popularmovies.data.repository.movies.datasource.remote.model.MoviesResultRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

  @GET("tv/popular?api_key=$API_KEY&language={language}&page={count}")
  suspend fun getPopularMovies(
    @Path("language") language: String,
    @Path("count") count: Int
  ): List<MoviesResultRemoteEntity>
}

private const val API_KEY = "c6aeee577586ba38e487b74dfede5deb"
private const val ES = "en-US"