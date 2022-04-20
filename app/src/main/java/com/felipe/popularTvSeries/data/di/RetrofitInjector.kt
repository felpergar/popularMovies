package com.felipe.popularTvSeries.data.di

import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitInjector {

  @Singleton
  @Provides
  fun provideRetrofit(): Retrofit =
    Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

  @Singleton
  @Provides
  fun provideTvSeriesApi(retrofit: Retrofit): TvSeriesApi {
    return retrofit.create(TvSeriesApi::class.java)
  }
}