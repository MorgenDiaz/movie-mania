package com.webslinger.portfolio.moviemania.data.networking.schema.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel

@JsonClass(generateAdapter = true)
data class CharacterListSchema(
    val page: Int,
    @Json(name = "results")
    val characterSchemas: List<CharacterSchema>,
    val total_pages: Int,
    val total_results: Int
): NetworkModel