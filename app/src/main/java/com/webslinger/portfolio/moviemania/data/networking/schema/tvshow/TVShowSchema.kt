package com.webslinger.portfolio.moviemania.data.networking.schema.tvshow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel

@JsonClass(generateAdapter = true)
data class TVShowSchema(
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "first_air_date")
    val firstAirDate: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    @Json(name = "origin_country")
    val originCountry: List<String>,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
): NetworkModel