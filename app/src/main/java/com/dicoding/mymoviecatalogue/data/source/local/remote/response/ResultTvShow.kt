package com.dicoding.mymoviecatalogue.data.source.local.remote.response

import com.google.gson.annotations.SerializedName

data class ResultTvShow(
    @SerializedName("id")
    var id: Int,

    @SerializedName("poster_path")
    var posterPath: String,

    @SerializedName("first_air_date")
    var firstAirDate: String,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("vote_average")
    var voteAverage : Double
)
