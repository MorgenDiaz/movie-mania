package com.webslinger.portfolio.moviemania.data.repository.movie.datasource

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.db.movie.MovieDAO
import com.webslinger.portfolio.moviemania.data.repository.movie.idatasource.IMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSource(private val movieDAO: MovieDAO): IMovieLocalDataSource {
    override suspend fun saveMovies(movies: List<DBMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun getMovies(): List<DBMovie> {
        return movieDAO.getAllMovies()
    }

    override suspend fun clearMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}