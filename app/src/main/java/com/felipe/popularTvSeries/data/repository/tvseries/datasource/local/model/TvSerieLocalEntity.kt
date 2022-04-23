package com.felipe.popularTvSeries.data.repository.tvseries.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo

@Entity(tableName = "tvserie")
class TvSerieLocalEntity(
  val posterImage: String?,
  @PrimaryKey val id: Int,
  val backdropImage: String?,
  val voteAverage: String,
  val description: String?,
  val firstAirDate: String?,
  val originCountry: String?,
  val originLanguage: String?,
  val originName: String
) {

  fun transformToTvSerieInfoDomain() =
    TvSerieInfo(posterImage, id, backdropImage, voteAverage, description, firstAirDate, originCountry, originLanguage, originName)

  fun transformToTvSerieDomain() =
    TvSerie(posterImage, id, backdropImage, voteAverage, description, firstAirDate, originCountry, originLanguage, originName)
}

fun TvSerie.transformToLocalEntity() =
  TvSerieLocalEntity(posterImage, id, backdropImage, voteAverage, description, firstAirDate, originCountry, originLanguage, originName)