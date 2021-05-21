package com.dicoding.mymoviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.mymoviecatalogue.Constant
import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.source.local.TvShow
import com.dicoding.mymoviecatalogue.databinding.ItemRowTvBinding
import com.dicoding.mymoviecatalogue.ui.detail.MovieTvDetailCourse

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvViewHolder>() {

    private var listTv = ArrayList<TvShow>()

    fun setTvShow(tvp: List<TvShow>) {
        if (tvp.isNotEmpty()) return
        listTv.clear()
        listTv.addAll(tvp)
    }

    inner class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowTvBinding.bind(itemView)
        fun bind(tv: TvShow) {
            binding.tvTitle.text = tv.name
            binding.tvRelease.text = tv.firstAirDate
            binding.tvAverage.text = tv.voteAverage.toString()
            Glide.with(itemView.context)
                .load(Constant.POSTER_BASE_URL + tv.posterPath)
                .into(binding.imgPoster)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MovieTvDetailCourse::class.java)
                intent.putExtra(MovieTvDetailCourse.EXTRA_TV, tv.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val tView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tv, parent, false)
        return TvViewHolder(tView)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(listTv[position])
    }

    override fun getItemCount() = listTv.size
}