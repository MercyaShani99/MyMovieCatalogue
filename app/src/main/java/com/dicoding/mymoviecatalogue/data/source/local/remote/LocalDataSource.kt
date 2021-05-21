package com.dicoding.mymoviecatalogue.data.source.local.remote

import androidx.lifecycle.LiveData
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.TvShow

interface LocalDataSource {
    fun getMoviePopular(): LiveData<List<Movie>>

    fun getMovieDetail(id: Int): LiveData<Movie>

    fun getTvPopular(): LiveData<List<TvShow>>

    fun getTvDetail(id: Int): LiveData<TvShow>
}