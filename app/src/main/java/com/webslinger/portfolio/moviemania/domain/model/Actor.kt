package com.webslinger.portfolio.moviemania.domain.model

data class Actor(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val knownFor: List<KnownFor>,
    val knownForDepartment: String,
    val name: String,
    val biography: String,
    val popularity: Double,
    val profilePath: String
)