package com.webslinger.portfolio.moviemania.data.repository.movie.datasource

import com.webslinger.portfolio.moviemania.data.networking.endpoints.MovieService
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovieList
import com.webslinger.portfolio.moviemania.data.repository.movie.idatasource.IMovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSource(private val movieService: MovieService, private val apiKey: String):
    IMovieRemoteDataSource {
    override suspend fun getMovies(): Response<NetworkMovieList> = movieService.getPopular(apiKey)
}