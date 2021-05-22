package com.dicoding.mymoviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.mymoviecatalogue.utils.DataDummy
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var observer: Observer<List<TvShow>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieTvRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.getTvPopular()
        val tvs = MutableLiveData<List<TvShow>>()
        tvs.value = dummyTvShow

        `when`(movieTvRepository.getTvPopular()).thenReturn(tvs)
        val tvEntities = viewModel.getTvShow().value
        verify(movieTvRepository).getTvPopular()
        assertNotNull(tvEntities)
        assertEquals(3, tvEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)

    }
}