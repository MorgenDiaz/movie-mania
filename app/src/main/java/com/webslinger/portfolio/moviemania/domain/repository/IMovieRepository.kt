package com.webslinger.portfolio.moviemania.domain.repository

import com.webslinger.portfolio.moviemania.domain.Movie

interface IMovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getUpdatedMovies(): List<Movie>
}