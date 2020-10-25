package com.webslinger.portfolio.moviemania.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.recyclerview.widget.RecyclerView
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.model.Movie

class MoviesViewAdapter(private val tmdbImageLoader: TmdbImageLoader): RecyclerView.Adapter<MovieItemViewHolder>() {
    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = inflate<TmdbItemBinding>(
            layoutInflater,
            R.layout.tmdb_item,
            parent,
            false
        )

        return MovieItemViewHolder(binding, tmdbImageLoader)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
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