package com.dicoding.mymoviecatalogue.data.source.local.remote

import android.util.Log
import com.dicoding.mymoviecatalogue.Constant.Companion.API_KEY
import com.dicoding.mymoviecatalogue.data.source.local.remote.api.ApiConfig
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.MovieRemoteResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.TvRemoteResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultMovie
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultTvShow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var inst: RemoteDataSource? = null

        fun getInst(): RemoteDataSource =
            inst ?: synchronized(this) {
                inst ?: RemoteDataSource()
            }
}

    fun getMoviePopular(callback: MovieCallback) =
        //espreso
        ApiConfig.getApiService().getMoviePopular(API_KEY)
            .enqueue(object : Callback<MovieRemoteResponse> {
                override fun onResponse(
                    call: Call<MovieRemoteResponse>,
                    response: Response<MovieRemoteResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie succeed")
                    callback.getMovieAsync(response.body()?.result)
                    //espreso
                }

                override fun onFailure(call: Call<MovieRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie failed : ${t.message}")
                    //espreso
                }
            })


    fun getTvPopular(callbackTv: TvCallback) {
        //espreso
        ApiConfig.getApiService().getTvPopular(API_KEY)
            .enqueue(object : Callback<TvRemoteResponse> {
                override fun onResponse(
                    call: Call<TvRemoteResponse>,
                    response: Response<TvRemoteResponse?>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Succed")
                    callbackTv.getTvAsync(response.body()?.result)
                    //espreso
                }

                override fun onFailure(call: Call<TvRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Failed : ${t.message}")
                    //espreso
                }

            })
    }

    interface MovieCallback {
        fun getMovieAsync(movie: List<ResultMovie>?)
    }

    interface TvCallback {
        fun getTvAsync(tv: List<ResultTvShow>?) {
        }
    }
}
