package com.dicoding.mymoviecatalogue.data.source.local.remote.response

import com.google.gson.annotations.SerializedName

data class TvRemoteResponse(

        @SerializedName("results")
    val result: List<ResultTvShow>
)
