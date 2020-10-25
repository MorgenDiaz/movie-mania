package com.webslinger.portfolio.moviemania.data.networking.model.actor

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/*
The Api sends null values instead of nothing for a field with no value so some fields must be nullable.
* */

@JsonClass(generateAdapter = true)
data class NetworkActorDetails(
    val adult: Boolean,
    @Json(name = "also_known_as")
    val alsoKnownAs: List<String>,
    val biography: String,
    val birthday: String?,
    val deathday: String?,
    val gender: Int,
    val homepage: String?,
    val id: Int,
    @Json(name = "imdb_id")
    val imdbId: String,
    @Json(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    @Json(name = "place_of_birth")
    val placeOfBirth: String,
    val popularity: Double,
    @Json(name = "profile_path")
    val profilePath: String
){
    companion object{
        val EMPTY_ACTOR = NetworkActorDetails(
            false,
            listOf(),
            "",
            "",
            "",
            -1,
            "",
            -1,
            "",
        "",
            "",
            "",
            -1.0,
            ""
        )
    }
}