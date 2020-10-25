package com.webslinger.portfolio.moviemania.data.db.actor

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actors_table")
data class DBActor (
    val adult: Boolean,
    val gender: Int,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    @ColumnInfo(name = "profile_path")
    val profilePath: String
)