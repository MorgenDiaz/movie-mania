package com.webslinger.portfolio.moviemania.domain

import com.webslinger.portfolio.moviemania.data.networking.schema.character.KnownForSchema

data class Character(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val knownFor: List<KnownForSchema>,
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    val profilePath: String
)