package com.webslinger.portfolio.moviemania.domain

interface IMovieRepository {
    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}