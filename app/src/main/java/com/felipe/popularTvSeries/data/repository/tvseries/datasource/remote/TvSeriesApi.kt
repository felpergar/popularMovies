package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote

import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.model.TvSeriesResultRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvSeriesApi {

  @GET("tv/popular?api_key=$API_KEY")
  suspend fun getPopularTvSeries(
  @Query("language") language: String = ES,
  @Query("count") count: Int
  ): TvSeriesResultRemoteEntity
}

private const val API_KEY = "c6aeee577586ba38e487b74dfede5deb"
private const val ES = "en-US"