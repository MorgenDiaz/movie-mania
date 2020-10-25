package com.webslinger.portfolio.moviemania.data.networking.model.actor

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkActorList(
    val page: Int,
    @Json(name = "results")
    val networkActors: List<NetworkActor>,
    val total_pages: Int,
    val total_results: Int
)