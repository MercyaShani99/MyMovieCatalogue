package com.dicoding.mymoviecatalogue.data.source.local.remote.api

import com.dicoding.mymoviecatalogue.data.source.local.remote.response.MovieDetailResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.MovieRemoteResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.TvDetailResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.TvRemoteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMoviePopular(
        @Query("api_key") apiKey:String
    ): Call<MovieRemoteResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey:String
    ): Call<MovieDetailResponse>

    @GET("tv/popular")
    fun getTvPopular(
        @Query("api_key") apiKey: String
    ): Call<TvRemoteResponse>

    @GET("tv/{tv_id}")
    fun getTvDetail(
        @Path("tv_id") id: Int,
        @Query("api_key") apiKey:String
    ): Call<TvDetailResponse>

}

