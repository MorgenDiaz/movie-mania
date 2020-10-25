package com.webslinger.portfolio.moviemania.domain.usecase.movie

import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.domain.repository.IMovieRepository

class GetMoviesUseCase(private val movieRepository: IMovieRepository) {
    suspend fun execute(): List<Movie> = movieRepository.getMovies()
}