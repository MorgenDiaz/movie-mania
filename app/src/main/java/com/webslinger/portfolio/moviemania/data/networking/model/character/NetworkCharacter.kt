package com.webslinger.portfolio.moviemania.data.networking.model.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCharacter(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    @Json(name = "known_for")
    val networkKnownFor: List<NetworkKnownFor>,
    @Json(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    @Json(name = "profile_path")
    val profilePath: String
)