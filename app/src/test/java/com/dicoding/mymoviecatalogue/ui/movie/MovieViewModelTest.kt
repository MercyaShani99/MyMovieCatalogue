package com.dicoding.mymoviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.mymoviecatalogue.utils.DataDummy
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieTvRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = DataDummy.getMoviePopular()
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovie

        `when`(movieTvRepository.getMoviePopular()).thenReturn(movies)
        val movieEntities = viewModel.getMovie().value
        verify(movieTvRepository).getMoviePopular()
        assertNotNull(movieEntities)
        assertEquals(3, movieEntities?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }
}