package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.model

import com.felipe.popularTvSeries.domain.tvseries.model.TvSerie
import com.google.gson.annotations.SerializedName

class TvSerieRemoteEntity(
  @SerializedName(POSTER_IMAGE) val posterImage: String?,
  @SerializedName(ID) val id: Int?,
  @SerializedName(BACKDROP_IMAGE) val backdropImage: String?,
  @SerializedName(VOTE_AVERAGE) val voteAverage: Float?,
  @SerializedName(OVERVIEW) val description: String?,
  @SerializedName(FIRST_AIR_DATE) val firstAirDate: String?,
  @SerializedName(ORIGIN_COUNTRY) val originCountry: List<String>?,
  @SerializedName(ORIGINAL_LANGUAGE) val originLanguage: String?,
  @SerializedName(ORIGINAL_NAME) val originName: String?
) {

  fun transformToDomain() =
    if (isValid())
      TvSerie(
        posterImage,
        id!!,
        backdropImage,
        voteAverage.toString(),
        description,
        firstAirDate,
        originCountry?.first(),
        originLanguage,
        originName!!
      )
    else null

  private fun isValid() = id != null && !originName.isNullOrBlank() && voteAverage != null  //This condition could be change, depend on PO
}

private const val POSTER_IMAGE = "poster_path"
private const val ID = "id"
private const val BACKDROP_IMAGE = "backdrop_path"
private const val VOTE_AVERAGE = "vote_average"
private const val OVERVIEW = "overview"
private const val FIRST_AIR_DATE = "first_air_date"
private const val ORIGIN_COUNTRY = "origin_country"
private const val ORIGINAL_LANGUAGE = "original_language"
private const val ORIGINAL_NAME = "original_name"
