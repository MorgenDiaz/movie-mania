package com.webslinger.portfolio.moviemania.data.db.actor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actor_details_table")
data class DBActorDetails (
    val adult: Boolean,
    @ColumnInfo(name = "also_known_as")
    val alsoKnownAs: List<String>,
    val biography: String,
    val birthday: String,
    val deathday: String,
    val gender: Int,
    val homepage: String,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "imdb_id")
    val imdbId: String,
    @ColumnInfo(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    @ColumnInfo(name = "place_of_birth")
    val placeOfBirth: String,
    val popularity: Double,
    @ColumnInfo(name = "profile_path")
    val profilePath: String
)