package com.dicoding.mymoviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.mymoviecatalogue.utils.DataDummy
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.dicoding.mymoviecatalogue.data.source.local.TvShow
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
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel

    private val dummyMovie = DataDummy.getMovieDetail()
    private val movieId = dummyMovie.id
    private val dummyTv = DataDummy.getTvDetail()
    private val tvId = dummyTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var movieObserver: Observer<Movie>

    @Mock
    private lateinit var tvObserver: Observer<TvShow>

    @Before
    fun setUpMovie() {
        detailViewModel = DetailViewModel(movieTvRepository)
    }

    @Test
    fun getMovie() {
        val movies = MutableLiveData<Movie>()
        movies.value = dummyMovie

        `when`(movieId.let { movieTvRepository.getMovieDetail(it) }).thenReturn(movies)

        val movieData = movieId.let { detailViewModel.getMovie(it).value } as Movie
        assertNotNull(movieData)
        assertEquals(dummyMovie.id, movieData.id)
        assertEquals(dummyMovie.posterPath, movieData.posterPath)
        assertEquals(dummyMovie.overview, movieData.overview)
        assertEquals(dummyMovie.releaseDate, movieData.releaseDate)
        assertEquals(dummyMovie.originalTitle, movieData.originalTitle)

        detailViewModel.getMovie(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Before
    fun setUpTv(){
        detailViewModel = DetailViewModel(movieTvRepository)
    }

    @Test
    fun getTvShow() {
        val tvs = MutableLiveData<TvShow>()
        tvs.value = dummyTv

        `when`(tvId.let { movieTvRepository.getTvDetail(it) }).thenReturn(tvs)

        val tvsData = tvId.let { detailViewModel.getTvShow(it).value } as TvShow

        assertNotNull(tvsData)
        assertEquals(dummyTv.id, tvsData.id)
        assertEquals(dummyTv.posterPath, tvsData.posterPath)
        assertEquals(dummyTv.overview, tvsData.overview)
        assertEquals(dummyTv.firstAirDate, tvsData.firstAirDate)
        assertEquals(dummyTv.name, tvsData.name)

        detailViewModel.getTvShow(tvId).observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTv)
    }
}