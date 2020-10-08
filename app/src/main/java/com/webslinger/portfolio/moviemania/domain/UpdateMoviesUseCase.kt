package com.webslinger.portfolio.moviemania.domain

class UpdateMoviesUseCase(private val moviesRepository: IMovieRepository) {
    suspend fun execute():List<Movie>? = moviesRepository.updateMovies()
}