package com.webslinger.portfolio.moviemania.data.networking.schema.tvshow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel

@JsonClass(generateAdapter = true)
data class TvShowsListSchema(
    val page: Int,
    @Json(name = "results")
    val tvShowSchemas: List<TVShowSchema>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
): INetworkModel