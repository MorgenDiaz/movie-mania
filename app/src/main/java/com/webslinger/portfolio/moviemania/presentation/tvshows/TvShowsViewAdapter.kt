package com.webslinger.portfolio.moviemania.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.model.TvShow

class TvShowsViewAdapter(private val tmdbImageLoader: TmdbImageLoader): RecyclerView.Adapter<TvShowItemViewHolder>() {
    private var tvShows: List<TvShow> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TmdbItemBinding>(inflater, R.layout.tmdb_item, parent, false)
        return TvShowItemViewHolder(binding, tmdbImageLoader)
    }

    override fun onBindViewHolder(holder: TvShowItemViewHolder, position: Int) {
        holder.bindTvShow(tvShows[position])
    }

    override fun getItemCount(): Int {
        return tvShows.count()
    }

    fun bindTvShows(tvShows: List<TvShow>){
        this.tvShows = tvShows
        notifyDataSetChanged()
    }
}