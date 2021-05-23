package com.dicoding.mymoviecatalogue.data.source.local.remote.response

import com.google.gson.annotations.SerializedName

data class TvDetailResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("vote_average")
    val voteAverage : Double
)
