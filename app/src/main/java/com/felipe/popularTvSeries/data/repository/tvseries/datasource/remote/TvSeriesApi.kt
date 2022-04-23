package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote

import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.model.TvSerieInfoRemoteEntity
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.model.TvSeriesResultRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvSeriesApi {

  @GET("tv/popular")
  suspend fun getPopularTvSeries(
    @Query("language") language: String,
    @Query("page") count: Int,
    @Query("api_key") apiKey: String = API_KEY
  ): TvSeriesResultRemoteEntity

  @GET("/tv/{id}")
  suspend fun getTvSerieInfo(
    @Path("id") id: Int,
    @Query("language") language: String,
    @Query("api_key") apiKey: String = API_KEY
  ): TvSerieInfoRemoteEntity
}

private const val API_KEY = "c6aeee577586ba38e487b74dfede5deb"
