package com.dicoding.mymoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.mymoviecatalogue.data.source.local.remote.LocalDataSource
import com.dicoding.mymoviecatalogue.data.source.local.remote.RemoteDataSource
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.MovieDetailResponse
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultMovie
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.ResultTvShow
import com.dicoding.mymoviecatalogue.data.source.local.remote.response.TvDetailResponse

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
        remoteDataSource.getMovieDetail(object : RemoteDataSource.DetailCallback {
            override fun getMovieDetailAsync(movieDetail: MovieDetailResponse) {
                val moviep = movieDetail.let {
                    Movie(
                        it.id,
                        it.posterPath,
                        it.overview,
                        it.releaseDate,
                        it.title,
                        it.voteAverage
                    )
                }
                moviewithIdResult.postValue(moviep)
            }
        }, id)
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
        remoteDataSource.getTvDetail(object : RemoteDataSource.DetailTvCallback {
            override fun getTvDetailAsync(tvDetail: TvDetailResponse) {
                val tvp = tvDetail.let {
                    TvShow(
                        it.id,
                        it.posterPath,
                        it.overview,
                        it.firstAirDate,
                        it.name,
                        it.voteAverage
                    )
                }
                tvIdResults.postValue(tvp)
            }
        }, id)
        return tvIdResults
    }
}