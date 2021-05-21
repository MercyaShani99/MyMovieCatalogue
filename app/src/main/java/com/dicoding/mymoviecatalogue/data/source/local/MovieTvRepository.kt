package com.dicoding.mymoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.mymoviecatalogue.data.source.local.remote.LocalDataSource
import com.dicoding.mymoviecatalogue.data.source.local.remote.RemoteDataSource
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultMovie
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultTvShow

class MovieTvRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    LocalDataSource {

    companion object {
        @Volatile
        private var instance: MovieTvRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieTvRepository =
            instance ?: synchronized(this) {
                instance ?: MovieTvRepository(remoteData).apply { instance = this }
            }
    }

    override fun getMoviePopular(): LiveData<List<Movie>> {
        val movieResult = MutableLiveData<List<Movie>>()
        remoteDataSource.getMoviePopular(callback = object : RemoteDataSource.MovieCallback {
            override fun getMovieAsync(movie: List<ResultMovie>?) {
                val moviePop = ArrayList<Movie>()
                if (movie != null) {
                    for (movieRes in movie) {
                        val movies = movieRes.let {
                            Movie(
                                it.id,
                                it.posterPath,
                                it.overview,
                                it.releaseDate,
                                it.title,
                                it.voteAverage,
                            )
                        }
                        moviePop.add(movies)
                    }
                }
                movieResult.postValue(moviePop)
            }
        })
        return movieResult
    }

    override fun getMovieDetail(id: Int): LiveData<Movie> {
        val moviesIdResults = MutableLiveData<Movie>()
        remoteDataSource.getMoviePopular(object : RemoteDataSource.MovieCallback {
            override fun getMovieAsync(movie: List<ResultMovie>?) {
                lateinit var moviep: Movie
                if (movie != null) {
                    for (movieidRes in movie){
                        if (movieidRes.id == id) {
                            moviep =
                                Movie(
                                movieidRes.id,
                                movieidRes.posterPath,
                                movieidRes.overview,
                                movieidRes.releaseDate,
                                movieidRes.title,
                                movieidRes.voteAverage
                                )
                        }
                        moviesIdResults.postValue(moviep)
                    }
                }
            }
        })
        return moviesIdResults
    }

    override fun getTvPopular(): LiveData<List<TvShow>> {
        val tvResult = MutableLiveData<List<TvShow>>()
        remoteDataSource.getTvPopular(object : RemoteDataSource.TvCallback {
            override fun getTvAsync(tv: List<ResultTvShow>?) {
                val tvPop = ArrayList<TvShow>()
                if (tv != null) {
                    for (tvRes in tv) {
                        val tvs = tvRes.let {
                            TvShow(
                                it.id,
                                it.posterPath,
                                it.overview,
                                it.firstAirDate,
                                it.name,
                                it.voteAverage,
                            )
                        }
                        tvPop.add(tvs)
                    }
                    tvResult.postValue(tvPop)
                }
            }
        })
        return tvResult
    }

    override fun getTvDetail(id: Int): LiveData<TvShow> {
        val tvIdResults = MutableLiveData<TvShow>()
        remoteDataSource.getTvPopular(object : RemoteDataSource.TvCallback {
            override fun getTvAsync(tv: List<ResultTvShow>?) {
                lateinit var tvp : TvShow
                if (tv != null) {
                    for (tvidRes in tv) {
                        if (tvidRes.id == id){
                            tvp =
                                TvShow(
                                    tvidRes.id,
                                    tvidRes.posterPath,
                                    tvidRes.overview,
                                    tvidRes.firstAirDate,
                                    tvidRes.name,
                                    tvidRes.voteAverage
                                )
                        }
                        tvIdResults.postValue(tvp)
                    }
                }
            }
        })
        return tvIdResults
    }
}