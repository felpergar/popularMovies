package com.felipe.popularTvSeries.domain.tvseries.di

import com.felipe.popularTvSeries.data.repository.tvseries.TvSeriesDataRepository
import com.felipe.popularTvSeries.domain.tvseries.TvSeriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RespositoryModule {

  @Binds
  abstract fun bindTvSerieDataRepository(
    tvSeriesRemoteDataSource: TvSeriesDataRepository
  ): TvSeriesRepository
}