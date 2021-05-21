package com.dicoding.mymoviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.mymoviecatalogue.Constant
import com.dicoding.mymoviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.data.source.local.MovieTvRepository
import com.dicoding.mymoviecatalogue.data.source.local.TvShow
import com.dicoding.mymoviecatalogue.databinding.ActivityMovieTvDetailCourseBinding
import com.dicoding.mymoviecatalogue.databinding.ContentMovieTvDetailCourseBinding

class MovieTvDetailCourse : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var detailCourseBinding: ContentMovieTvDetailCourseBinding
    private lateinit var movieTvRepository: MovieTvRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activitydetailBinding = ActivityMovieTvDetailCourseBinding.inflate(layoutInflater)
        detailCourseBinding = activitydetailBinding.detailContent

        setContentView(activitydetailBinding.root)
        setSupportActionBar(activitydetailBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInst()
        val viewModelProvider = ViewModelProvider(this,factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if(extras != null) {
            val movie = extras.getInt(EXTRA_MOVIES, 0)
            val tvs = extras.getInt(EXTRA_TV,0)

            if(movie != null) {
                activitydetailBinding.progressBar.visibility = View.VISIBLE
                activitydetailBinding.nestedScrollView.visibility = View.INVISIBLE

                viewModelProvider.setSelectedMovie(movie)
                viewModelProvider.getMovie().observe(this, {movieEntities ->
                    activitydetailBinding.progressBar.visibility = View.GONE
                    activitydetailBinding.nestedScrollView.visibility = View.VISIBLE

                    popularMovie(movieEntities)
                })
            } else if (tvs != null){
                activitydetailBinding.progressBar.visibility = View.VISIBLE
                activitydetailBinding.nestedScrollView.visibility = View.INVISIBLE

                viewModelProvider.setSelectedTvs(tvs)
                viewModelProvider.getTvShow().observe(this, {tvShowEntities ->
                    activitydetailBinding.progressBar.visibility = View.GONE
                    activitydetailBinding.nestedScrollView.visibility = View.VISIBLE

                    popularTvShow(tvShowEntities)
                })
            }
        }
}
    private fun popularMovie(movieEntities: Movie){
        detailCourseBinding.textTitle.text = movieEntities.originalTitle
        detailCourseBinding.textRelease.text = movieEntities.releaseDate
        detailCourseBinding.textDes.text = movieEntities.overview
        detailCourseBinding.textAverage.text = movieEntities.voteAverage.toString()

        Glide.with(this)
            .load(Constant.POSTER_BASE_URL + movieEntities.posterPath)
            .transform(RoundedCorners(20))
            .into(detailCourseBinding.imagePoster)
    }

    private fun popularTvShow(tvShowEntities: TvShow){
        detailCourseBinding.textTitle.text = tvShowEntities.name
        detailCourseBinding.textRelease.text = tvShowEntities.firstAirDate
        detailCourseBinding.textDes.text = tvShowEntities.overview
        detailCourseBinding.textAverage.text = tvShowEntities.voteAverage.toString()

        Glide.with(this)
            .load(Constant.POSTER_BASE_URL + tvShowEntities.posterPath)
            .transform(RoundedCorners(20))
            .into(detailCourseBinding.imagePoster)
    }
}