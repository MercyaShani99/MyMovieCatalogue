package com.dicoding.mymoviecatalogue.data.source.local.remote.api

import com.dicoding.mymoviecatalogue.data.source.local.remote.response.MovieRemoteResponse
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

    @GET("tv/{tv_id}?api_key=c44284fb2fadf0bfb7e77ef1805b48cb&language=en-US")
    fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey:String
    ): Call<MovieRemoteResponse>

    @GET("tv/popular")
    fun getTvPopular(
        @Query("api_key") apiKey: String
    ): Call<TvRemoteResponse>

    @GET("tv/{tv_id}?api_key=c44284fb2fadf0bfb7e77ef1805b48cb&language=en-US")
    fun getTvDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey:String
    ): Call<TvRemoteResponse>

}

