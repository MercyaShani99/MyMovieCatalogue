package com.dicoding.mymoviecatalogue.data.source.local.remote

import android.util.Log
import com.dicoding.mymoviecatalogue.Constant.Companion.API_KEY
import com.dicoding.mymoviecatalogue.data.source.local.remote.api.ApiConfig
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.*
import com.dicoding.mymoviecatalogue.utils.EspressoIdlingResource
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

    fun getMoviePopular(callback: MovieCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMoviePopular(API_KEY)
            .enqueue(object : Callback<MovieRemoteResponse> {
                override fun onResponse(
                    call: Call<MovieRemoteResponse>,
                    response: Response<MovieRemoteResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie succeed")
                    callback.getMovieAsync(response.body()?.result)
                    EspressoIdlingResource.decrement()
                    //espreso
                }

                override fun onFailure(call: Call<MovieRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie failed : ${t.message}")
                    EspressoIdlingResource.decrement()
                    //espreso
                }
            })
    }

    fun getTvPopular(callbackTv: TvCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvPopular(API_KEY)
            .enqueue(object : Callback<TvRemoteResponse> {
                override fun onResponse(
                    call: Call<TvRemoteResponse>,
                    response: Response<TvRemoteResponse?>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Succed")
                    callbackTv.getTvAsync(response.body()?.result)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvRemoteResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Failed : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getMovieDetail(callback: DetailCallback, id: Int) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovieDetail(id, API_KEY)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie succeed")
                    response.body()?.let { callback.getMovieDetailAsync(it) }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Failed : ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvDetail(callback: DetailTvCallback, id: Int) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvDetail(id, API_KEY)
            .enqueue(object : Callback<TvDetailResponse> {
                override fun onResponse(
                    call: Call<TvDetailResponse>,
                    response: Response<TvDetailResponse>
                ) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Succed")
                    response.body()?.let { callback.getTvDetailAsync(it) }
                    EspressoIdlingResource.decrement()
                }
                override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "get Movie Failed : ${t.message}")
                    EspressoIdlingResource.decrement()
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

    interface DetailCallback {
        fun getMovieDetailAsync(movieDetail: MovieDetailResponse) {
        }
    }

    interface DetailTvCallback {
        fun getTvDetailAsync(tvDetail: TvDetailResponse) {
        }
    }
}
