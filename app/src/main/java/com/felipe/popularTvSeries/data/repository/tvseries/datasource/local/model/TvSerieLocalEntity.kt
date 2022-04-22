package com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.model

import androidx.room.Entity

@Entity(tableName = "tvserie")
class TvSerieLocalEntity (
  val posterImage: String?,
  val id: Int,
  val backdropImage: String?,
  val voteAverage: String,
  val description: String?,
  val firstAirDate: String?,
  val originCountry: String?,
  val originLanguage: String?,
  val originName: String
)