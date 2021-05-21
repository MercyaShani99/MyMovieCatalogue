package com.dicoding.mymoviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.dicoding.mymoviecatalogue.data.source.local.TvShow

class TvShowViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel(){
    fun getTvShow() : LiveData<List<TvShow>> = movieTvRepository.getTvPopular()
}