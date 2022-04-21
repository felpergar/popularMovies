package com.felipe.popularTvSeries.mobile.mainView.model

import android.os.Parcelable
import com.felipe.popularTvSeries.domain.movies.model.TvSerie
import kotlinx.parcelize.Parcelize

@Parcelize
class TvSerieViewEntity(
  val posterImage: String?,
  val id: Int?,
  val backdropImage: String?,
  val voteAverage: String?,
  val description: String?,
  val firstAirDate: String?,
  val originCountry: String?,
  val originLanguage: String?,
  val originalName: String?
): Parcelable

fun List<TvSerie>.transformToViewEntity() = map { it.transformToViewEntity() }

private fun TvSerie.transformToViewEntity() =
  TvSerieViewEntity(posterImage, id, backdropImage, voteAverage, description, firstAirDate, originCountry, originLanguage, originName)