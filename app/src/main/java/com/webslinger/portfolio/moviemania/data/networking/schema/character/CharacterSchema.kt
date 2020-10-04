package com.webslinger.portfolio.moviemania.data.networking.schema.character

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterSchema(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    @Json(name = "known_forSchema")
    val knownForSchema: List<KnownForSchema>,
    @Json(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    @Json(name = "profile_path")
    val profilePath: String
)