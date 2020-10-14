package com.webslinger.portfolio.moviemania.data.repository.movie.idatasource

import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovieList
import retrofit2.Response

interface IMovieRemoteDataSource {
    suspend fun getMovies(): Response<NetworkMovieList>
}