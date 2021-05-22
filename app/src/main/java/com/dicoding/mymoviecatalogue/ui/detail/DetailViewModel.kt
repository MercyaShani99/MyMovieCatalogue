package com.dicoding.mymoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.dicoding.mymoviecatalogue.data.source.local.TvShow

class DetailViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    private var id: Int = 0

    fun setSelectedMovie(id : Int){
        this.id = id
    }

    fun setSelectedTvs(id : Int){
        this.id = id
    }

    fun getMovie(id:Int) : LiveData<Movie> = movieTvRepository.getMovieDetail(id)

    fun getTvShow(id: Int) : LiveData<TvShow> = movieTvRepository.getTvDetail(id)
}