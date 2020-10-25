package com.webslinger.portfolio.moviemania.domain.usecase.movie

import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.domain.repository.IMovieRepository

class UpdateMoviesUseCase(private val moviesRepository: IMovieRepository) {
    suspend fun execute():List<Movie> = moviesRepository.getUpdatedMovies()
}