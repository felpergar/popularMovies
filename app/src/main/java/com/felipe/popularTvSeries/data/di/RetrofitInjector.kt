package com.felipe.popularTvSeries.data.di

import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitInjector {

  @Singleton
  @Provides
  fun provideRetrofit(): Retrofit {
    val okHttpClient = HttpLoggingInterceptor().run {
      level = HttpLoggingInterceptor.Level.BODY
      OkHttpClient.Builder().addInterceptor(this).build()
    }

    return Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Singleton
  @Provides
  fun provideTvSeriesApi(retrofit: Retrofit): TvSeriesApi {
    return retrofit.create(TvSeriesApi::class.java)
  }
}