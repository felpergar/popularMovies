package com.felipe.popularTvSeries.data.repository.tvseries.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.model.TvSerieLocalEntity

@Dao
interface TvSerieDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveTvSeries(tvSeries: List<TvSerieLocalEntity>): List<Long>

  @Query("SELECT * FROM tvserie where id = :id")
  fun getTvSerieInfo(id: Int): TvSerieLocalEntity

  @Query("SELECT * FROM tvserie")
  fun getPopularTvSeries(): List<TvSerieLocalEntity>

  @Query("DELETE FROM tvserie")
  fun deleteDataBase()
}