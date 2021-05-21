package com.dicoding.mymoviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository

class MovieViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel(){
    fun getMovie() : LiveData<List<Movie>> = movieTvRepository.getMoviePopular()
}