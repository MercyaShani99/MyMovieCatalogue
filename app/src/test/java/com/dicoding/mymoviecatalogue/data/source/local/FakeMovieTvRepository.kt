package com.dicoding.mymoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.mymoviecatalogue.data.source.local.remote.LocalDataSource
import com.dicoding.mymoviecatalogue.data.source.local.remote.RemoteDataSource
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultMovie
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultTvShow

class FakeMovieTvRepository(private val remoteDataSource: RemoteDataSource) :
    LocalDataSource {

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
        val moviewithIdResult = MutableLiveData<Movie>()
        remoteDataSource.getMoviePopular(object : RemoteDataSource.MovieCallback {
            override fun getMovieAsync(movie: List<ResultMovie>?) {
                if (movie != null) {
                    for (movieidRes in movie){
                        if (movieidRes.id == id) {
                            val moviep = Movie(
                                movieidRes.id,
                                movieidRes.posterPath,
                                movieidRes.overview,
                                movieidRes.releaseDate,
                                movieidRes.title,
                                movieidRes.voteAverage
                            )
                            moviewithIdResult.postValue(moviep)
                            break
                        }
                    }
                }
            }
        })
        return moviewithIdResult
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
                if (tv != null) {
                    for (tvidRes in tv) {
                        if (tvidRes.id == id){
                            val tvp = TvShow(
                                tvidRes.id,
                                tvidRes.posterPath,
                                tvidRes.overview,
                                tvidRes.firstAirDate,
                                tvidRes.name,
                                tvidRes.voteAverage
                            )
                            tvIdResults.postValue(tvp)
                            break
                        }
                    }
                }
            }
        })
        return tvIdResults
    }

}