package com.felipe.popularTvSeries.data.di

import android.content.Context
import androidx.room.Room
import com.felipe.popularTvSeries.data.database.TvSeriesDataBase
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.TvSerieDao
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Injector {

  @Singleton
  @Provides
  fun provideRetrofit(): Retrofit =
    Retrofit.Builder()
      .baseUrl("http://api.themoviedb.org/3/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

  @Singleton
  @Provides
  fun provideTvSeriesApi(retrofit: Retrofit): TvSeriesApi {
    return retrofit.create(TvSeriesApi::class.java)
  }

  @Singleton
  @Provides
  fun provideTvSerieDao(dataBase: TvSeriesDataBase): TvSerieDao {
    return dataBase.getTvSerieDao()
  }

  @Provides
  @Singleton
  fun provideAppDatabase(@ApplicationContext appContext: Context): TvSeriesDataBase =
    Room.databaseBuilder(
      appContext,
      TvSeriesDataBase::class.java,
      "RssReader"
    ).build()
}