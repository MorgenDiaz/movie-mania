package com.webslinger.portfolio.moviemania.data.repository

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie

interface IMovieLocalDataSource {
    suspend fun saveMovies(movies: List<DBMovie>)
    suspend fun getMovies(): List<DBMovie>
    suspend fun clearAll()
}