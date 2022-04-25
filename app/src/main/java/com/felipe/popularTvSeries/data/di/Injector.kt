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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Injector {

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

  @Singleton
  @Provides
  fun provideLocation(): Locale {
    return Locale.getDefault()
  }
}