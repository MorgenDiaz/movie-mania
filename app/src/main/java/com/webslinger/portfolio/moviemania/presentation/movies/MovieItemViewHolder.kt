package com.webslinger.portfolio.moviemania.presentation.movies

import androidx.recyclerview.widget.RecyclerView
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.model.Movie

class MovieItemViewHolder(
    private val binding: TmdbItemBinding,
    private val tmdbImageLoader: TmdbImageLoader
): RecyclerView.ViewHolder(binding.root) {
    fun bindMovie(movie: Movie){
        binding.titleTextView.text = movie.title

        loadMovieImage(movie.backdropPath)

        binding.descriptionTextView.text = movie.overview
    }

    private fun loadMovieImage(imagePath: String) {
        tmdbImageLoader.loadToImageView(
            binding.root,
            imagePath,
            binding.tmdbImageView
        )
    }
}