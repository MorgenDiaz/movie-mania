package com.webslinger.portfolio.moviemania.data.repository

import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieListSchema
import retrofit2.Response

interface IMovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieListSchema>
}