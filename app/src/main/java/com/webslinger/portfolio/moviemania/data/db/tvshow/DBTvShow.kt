package com.webslinger.portfolio.moviemania.data.db.tvshow

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_shows_table")
data class DBTvShow (
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>,
    @PrimaryKey()
    val id: Int,
    val name: String,
    @ColumnInfo(name = "origin_country")
    val originCountry: List<String>,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_name")
    val originalName: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int
)