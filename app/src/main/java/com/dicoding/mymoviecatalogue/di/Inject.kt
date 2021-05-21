package com.dicoding.mymoviecatalogue.di

import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.dicoding.mymoviecatalogue.data.source.local.remote.RemoteDataSource

object Inject {
    fun provideRepository(): MovieTvRepository {
        val remoteDataSource = RemoteDataSource.getInst()
        return MovieTvRepository.getInstance(remoteDataSource)
    }
}