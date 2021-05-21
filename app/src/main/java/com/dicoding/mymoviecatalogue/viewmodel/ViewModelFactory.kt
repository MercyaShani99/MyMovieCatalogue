package com.dicoding.mymoviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.dicoding.mymoviecatalogue.di.Inject
import com.dicoding.mymoviecatalogue.ui.detail.DetailViewModel
import com.dicoding.mymoviecatalogue.ui.movie.MovieViewModel
import com.dicoding.mymoviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val factMovieTvRepository: MovieTvRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var inst: ViewModelFactory? = null

        fun getInst(): ViewModelFactory =
            inst ?: synchronized(this)
            {
                ViewModelFactory(Inject.provideRepository()).apply {
                    inst = this
                }
            }
    }

    //@Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) ->{
                MovieViewModel(factMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) ->{
                TvShowViewModel(factMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) ->{
                DetailViewModel(factMovieTvRepository) as T
            }
            else ->  throw Throwable("Tidak ada viewModel class di factory yg sesuai :" + modelClass.name)
        }
    }
}