package com.felipe.popularTvSeries.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.TvSerieDao
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.model.TvSerieLocalEntity

@Database(entities = [TvSerieLocalEntity::class,], version = 1)
abstract class TvSeriesDataBase : RoomDatabase() {

  abstract fun getTransactionDataBase(): TvSerieDao

  companion object {
    fun buildDatabase(context: Context) =
      Room.databaseBuilder(context, TvSeriesDataBase::class.java, "TvSeriesDataBase")
        .fallbackToDestructiveMigration()
        .build()
  }
}