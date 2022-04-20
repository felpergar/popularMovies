package com.felipe.popularmovies.data.repository.movies.datasource.remote.model

import com.google.gson.annotations.SerializedName

class MoviesResultRemoteEntity(
  @SerializedName(RESULTS) val movies: List<MovieRemoteEntity>
)

private const val RESULTS = "results"