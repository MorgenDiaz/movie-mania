package com.webslinger.portfolio.moviemania.presentation.tvshows

import androidx.recyclerview.widget.RecyclerView
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.model.TvShow

class TvShowItemViewHolder(
    private val binding: TmdbItemBinding,
    private val tmdbImageLoader: TmdbImageLoader
): RecyclerView.ViewHolder(binding.root) {
    fun bindTvShow(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name

        loadTvShowImage(tvShow.backdropPath)

        binding.descriptionTextView.text = tvShow.overview
    }

    private fun loadTvShowImage(imagePath: String) {
        tmdbImageLoader.loadToImageView(
            binding.root,
            imagePath,
            binding.tmdbImageView
        )
    }
}