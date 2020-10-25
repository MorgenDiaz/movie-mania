package com.webslinger.portfolio.moviemania.data.repository.movie.datasource

import com.webslinger.portfolio.moviemania.data.repository.movie.idatasource.IMovieCacheDataSource
import com.webslinger.portfolio.moviemania.domain.model.Movie

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