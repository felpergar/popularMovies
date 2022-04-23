package com.felipe.popularTvSeries.mobile.detail.model

import com.felipe.popularTvSeries.domain.tvseries.model.TvSerieInfo

class TvSerieInfoViewEntity(
  val posterImage: String?,
  val id: Int,
  val backdropImage: String?,
  val voteAverage: String,
  val description: String?,
  val firstAirDate: String?,
  val originCountry: String?,
  val originLanguage: String?,
  val originalName: String
)

fun TvSerieInfo.transformToViewEntity() =
  TvSerieInfoViewEntity(posterImage, id, backdropImage, voteAverage, description, firstAirDate, originCountry, originLanguage, originName)