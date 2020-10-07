package com.webslinger.portfolio.moviemania.data.db.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.KnownForSchema

@Entity(tableName = "characters_table")
data class DBCharacter (
    val adult: Boolean,
    val gender: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "known_for")
    val knownFor: List<KnownForSchema>,
    @ColumnInfo(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    val popularity: Double,
    @ColumnInfo(name = "profile_path")
    val profilePath: String
): DataBaseModel