package com.webslinger.portfolio.moviemania.data.repository.movie.idatasource

import com.webslinger.portfolio.moviemania.domain.Movie

interface IMovieCacheDataSource {
    suspend fun getMovies(): List<Movie>
    suspend fun updateMovies(movies: List<Movie>)
}