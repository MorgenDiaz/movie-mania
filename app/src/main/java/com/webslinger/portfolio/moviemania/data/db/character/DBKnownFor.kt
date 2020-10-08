package com.webslinger.portfolio.moviemania.data.db.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel

@Entity(tableName = "known_for_table")
data class DBKnownFor (
    val adult: Boolean,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "media_type")
    val mediaType: String,
    val name: String,
    @ColumnInfo(name = "origin_country")
    val originCountry: List<String>,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_name")
    val originalName: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    val overview: String,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int
): DataBaseModel