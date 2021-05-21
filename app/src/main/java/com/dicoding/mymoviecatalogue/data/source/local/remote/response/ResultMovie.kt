package com.dicoding.mymoviecatalogue.data.source.local.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultMovie(
    @SerializedName("id")
    var id: Int,

    @SerializedName("poster_path")
    var posterPath: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("vote_average")
    var voteAverage : Double
):Parcelable
