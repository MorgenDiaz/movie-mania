package com.webslinger.portfolio.moviemania.data.networking.endpoints

import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopular(@Query("api_key") apiKey: String): Response<NetworkMovieList>
}