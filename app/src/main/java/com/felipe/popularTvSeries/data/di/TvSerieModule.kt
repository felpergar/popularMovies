package com.felipe.popularTvSeries.data.di

import com.felipe.popularTvSeries.data.repository.tvseries.datasource.TvSeriesDataSource
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.TvSeriesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TvSerieModule {

  @TvSerieRemoteDataSource
  @Binds
  @ActivityScoped
  abstract fun bindTvSerieRemoteDataSource(
    tvSeriesRemoteDataSource: TvSeriesRemoteDataSource
  ):TvSeriesDataSource
}