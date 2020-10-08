package com.webslinger.portfolio.moviemania.data.repository

import com.webslinger.portfolio.moviemania.domain.Movie

interface IMovieCacheDataSource {
    suspend fun getMovies(): List<Movie>
    suspend fun updateMovies(movies: List<Movie>)
}