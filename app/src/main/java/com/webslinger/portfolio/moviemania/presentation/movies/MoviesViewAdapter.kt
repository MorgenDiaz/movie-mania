package com.webslinger.portfolio.moviemania.presentation.movies

import android.text.method.MovementMethod
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.Movie
import kotlinx.android.synthetic.main.tmdb_item.view.*

class MoviesViewAdapter(): RecyclerView.Adapter<MoviesViewAdapter.MovieViewHolder>() {
    private var movies: List<Movie> = listOf()

    class MovieViewHolder(
        private val binding: TmdbItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindMovie(movie: Movie){
            binding.titleTextView.text = movie.title

            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/original${movie.backdropPath}")
                .into(binding.tmdbImageView)

            binding.descriptionTextView.text = movie.overview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = inflate<TmdbItemBinding>(
            layoutInflater,
            R.layout.tmdb_item,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.count()
    }

    fun bindMovies(movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }
}