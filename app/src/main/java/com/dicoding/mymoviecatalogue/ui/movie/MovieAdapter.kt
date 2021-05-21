package com.dicoding.mymoviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.mymoviecatalogue.Constant
import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.source.local.Movie
import com.dicoding.mymoviecatalogue.databinding.ItemRowMovieBinding
import com.dicoding.mymoviecatalogue.ui.detail.MovieTvDetailCourse

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMoviep = ArrayList<Movie>()

    fun setMovie(moviep: List<Movie>) {
        if (moviep.isEmpty()) return
        listMoviep.clear()
        listMoviep.addAll(moviep)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowMovieBinding.bind(itemView)
        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.originalTitle
            binding.tvRelease.text = movie.releaseDate
            binding.tvAverage.text = movie.voteAverage.toString()
            Glide.with(itemView.context)
                .load(Constant.POSTER_BASE_URL + movie.posterPath)
                .into(binding.imgPoster)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MovieTvDetailCourse::class.java)
                intent.putExtra(MovieTvDetailCourse.EXTRA_MOVIES, movie.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return MovieViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(listMoviep[position])
    }

    override fun getItemCount() = listMoviep.size
}