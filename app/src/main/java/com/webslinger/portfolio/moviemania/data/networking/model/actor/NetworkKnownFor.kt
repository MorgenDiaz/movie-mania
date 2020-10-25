package com.webslinger.portfolio.moviemania.data.networking.model.actor

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

const val NOT_AVAILABLE = "Not Available"
@JsonClass(generateAdapter = true)
data class NetworkKnownFor(
    val adult: Boolean = false,
    @Json(name="backdrop_path")
    val backdropPath: String = NOT_AVAILABLE,
    @Json(name="first_air_date")
    val firstAirDate: String = NOT_AVAILABLE,
    @Json(name="genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @Json(name="media_type")
    val mediaType: String,
    val name: String = NOT_AVAILABLE,
    @Json(name="origin_country")
    val originCountry: List<String> = listOf(),
    @Json(name="original_language")
    val originalLanguage: String = NOT_AVAILABLE,
    @Json(name="original_name")
    val originalName: String = NOT_AVAILABLE,
    @Json(name="original_title")
    val originalTitle: String = NOT_AVAILABLE,
    val overview: String,
    @Json(name="poster_path")
    val posterPath: String,
    @Json(name="release_date")
    val releaseDate: String = NOT_AVAILABLE,
    val title: String = NOT_AVAILABLE,
    val video: Boolean = false,
    @Json(name="vote_average")
    val voteAverage: Double,
    @Json(name="vote_count")
    val voteCount: Int
)