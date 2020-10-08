package com.webslinger.portfolio.moviemania.data.repository

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.domain.Movie

class MovieCahceDataSource: IMovieCacheDataSource {
    private val movieCache: MutableList<Movie> = mutableListOf()

    override suspend fun getMovies(): List<Movie> {
        return movieCache
    }

    override suspend fun updateMovies(movies: List<Movie>){
        movieCache.clear()
        movieCache.addAll(movies)
    }
}