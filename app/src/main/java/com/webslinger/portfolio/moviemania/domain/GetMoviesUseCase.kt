package com.webslinger.portfolio.moviemania.domain

class GetMoviesUseCase(private val movieRepository: IMovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}