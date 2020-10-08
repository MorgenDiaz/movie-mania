package com.webslinger.portfolio.moviemania.data.repository

import com.webslinger.portfolio.moviemania.data.networking.endpoints.MovieService
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieListSchema
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieSchema
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieRemoteDataSource(private val movieService: MovieService, private val apiKey: String): IMovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieListSchema> = movieService.getPopular(apiKey)
}