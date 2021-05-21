package com.dicoding.mymoviecatalogue.data.source.local

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("vote_average")
    val voteAverage: Double
): Parcelable
