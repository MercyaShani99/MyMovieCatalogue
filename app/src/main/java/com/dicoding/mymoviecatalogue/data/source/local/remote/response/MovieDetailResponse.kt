package com.dicoding.mymoviecatalogue.data.source.local.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val overview: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)
