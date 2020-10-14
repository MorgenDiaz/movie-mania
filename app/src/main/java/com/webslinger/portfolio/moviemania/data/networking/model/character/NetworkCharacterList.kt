package com.webslinger.portfolio.moviemania.data.networking.model.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCharacterList(
    val page: Int,
    @Json(name = "results")
    val networkCharacters: List<NetworkCharacter>,
    val total_pages: Int,
    val total_results: Int
)