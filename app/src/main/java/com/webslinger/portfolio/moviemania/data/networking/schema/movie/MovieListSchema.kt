package com.webslinger.portfolio.moviemania.data.networking.schema.movie

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel

@JsonClass(generateAdapter = true)
data class MovieListSchema(
    val page: Int,
    @Json(name = "results")
    val movieSchemas: List<MovieSchema>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
): NetworkModel