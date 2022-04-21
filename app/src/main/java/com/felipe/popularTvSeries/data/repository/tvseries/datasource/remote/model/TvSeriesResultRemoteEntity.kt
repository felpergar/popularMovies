package com.felipe.popularTvSeries.data.repository.tvseries.datasource.remote.model

import com.google.gson.annotations.SerializedName

class TvSeriesResultRemoteEntity(
  @SerializedName(RESULTS) val movies: List<TvSerieRemoteEntity>
) {

  fun transformToDomain() = movies.mapNotNull { it.transformToDomain() }
}

private const val RESULTS = "results"