package com.webslinger.portfolio.moviemania.domain.usecase.movie

import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.domain.repository.IMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateMoviesUseCase(private val moviesRepository: IMovieRepository) {
    suspend fun execute():List<Movie>{
        return withContext(Dispatchers.IO){
            moviesRepository.getUpdatedMovies()
        }
    }

}