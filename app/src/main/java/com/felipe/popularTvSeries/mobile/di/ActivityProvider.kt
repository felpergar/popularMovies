package com.felipe.popularTvSeries.mobile.di

import android.app.Activity
import com.felipe.popularTvSeries.mobile.detail.DetailActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
object ActivityProvider {

  @Provides
  fun bindActivity(activity: Activity): DetailActivity {
    return activity as DetailActivity
  }
}

