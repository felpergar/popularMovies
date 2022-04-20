package com.felipe.popularmovies.data.di

import com.felipe.popularmovies.data.repository.movies.datasource.remote.MoviesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RetrofitInjector {

  @Provides
  fun provideRetrofit(): Retrofit =
    Retrofit.Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

  @Provides
  fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
    return retrofit.create(MoviesApi::class.java)
  }
}