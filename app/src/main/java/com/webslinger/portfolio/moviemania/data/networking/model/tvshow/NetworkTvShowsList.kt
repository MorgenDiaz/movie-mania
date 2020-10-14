package com.webslinger.portfolio.moviemania.data.networking.model.tvshow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkTvShowsList(
    val page: Int,
    @Json(name = "results")
    val networkTvShows: List<NetworkTVShow>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)