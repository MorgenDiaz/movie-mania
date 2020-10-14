package com.webslinger.portfolio.moviemania.data.networking.model.movie

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkMovieList(
    val page: Int,
    @Json(name = "results")
    val networkMovies: List<NetworkMovie>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)