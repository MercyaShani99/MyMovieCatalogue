package com.dicoding.mymoviecatalogue.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.mymoviecatalogue.data.source.local.remote.RemoteDataSource
import com.dicoding.mymoviecatalogue.utils.DataDummy
import com.dicoding.mymoviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.mock

class MovieTvRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieTvRepository = FakeMovieTvRepository(remote)

    private val moviesResponse = DataDummy.getMoviesResponse()
    private val movieId = moviesResponse[0].id
    private val movieDetail = DataDummy.getMovieDetailResponse()

    private val tvResponse = DataDummy.getTvShowResponse()
    private val tvShowId = tvResponse[0].id
    private val tvShowDetail = DataDummy.getTvShowDetailResponse()

    @Test
    fun getMoviePopular() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.MovieCallback).getMovieAsync(moviesResponse)
            null
        }.`when`(remote).getMoviePopular(any())

        val movieEntities =LiveDataTestUtil.getValue(movieTvRepository.getMoviePopular())
        verify(remote).getMoviePopular(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.MovieCallback).getMovieAsync(moviesResponse)
            null
        }.`when`(remote).getMoviePopular(any(), eq(movieId))

        val movieDetailEntities = LiveDataTestUtil.getValue(movieTvRepository.getMovieDetail(movieId))
        verify(remote).getMoviePopular(any(), eq(movieId))
        assertNotNull(movieDetailEntities)
        assertEquals(movieDetail.id, movieDetailEntities.id)
    }

    @Test
    fun getTvPopular() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.TvCallback).getTvAsync(tvResponse)
            null
        }.`when`(remote).getTvPopular(any())

        val tvShowEntities = LiveDataTestUtil.getValue(movieTvRepository.getTvPopular())
        verify(remote).getTvPopular(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvResponse.size, tvShowEntities.size)
    }

    @Test
    fun getTvDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.TvCallback).getTvAsync(tvResponse)
            null
        }.`when`(remote).getTvPopular(any(), eq(tvShowId))

        val tvShowDetailEntities = LiveDataTestUtil.getValue(movieTvRepository.getTvDetail(tvShowId))
        verify(remote).getTvPopular(any(), eq(tvShowId))
        assertNotNull(tvShowDetailEntities)
        assertEquals(tvShowDetail.id, tvShowDetailEntities.id)
    }
}