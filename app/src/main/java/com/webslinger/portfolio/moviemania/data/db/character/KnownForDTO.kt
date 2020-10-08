package com.webslinger.portfolio.moviemania.data.db.character

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.webslinger.portfolio.moviemania.data.dto.common.DTO
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.KnownForSchema

class KnownForDTO(private val characterId: Int) : DTO {
    override fun schemaToDBModel(networkModel: NetworkModel): DBKnownFor {
        if (!KnownForSchema::class.java.isAssignableFrom(networkModel::class.java)) {
            throw IllegalArgumentException("Invalid known for schema.")
        }

        (networkModel as KnownForSchema).apply {
            return DBKnownFor(
                adult,
                backdropPath,
                firstAirDate,
                genreIds,
                id,
                characterId,
                mediaType,
                name,
                originCountry,
                originalLanguage,
                originalName,
                originalTitle,
                overview,
                posterPath,
                releaseDate,
                title,
                video,
                voteAverage,
                voteCount
            )
        }
    }

    override fun dbModelToSchema(dbModel: DataBaseModel): KnownForSchema {
        if (!DBKnownFor::class.java.isAssignableFrom(dbModel::class.java)) {
            throw IllegalArgumentException("Invalid known for data base model.")
        }

        (dbModel as DBKnownFor).apply{
            return KnownForSchema(
                adult,
                backdropPath,
                firstAirDate,
                genreIds,
                id, mediaType,
                name,
                originCountry,
                originalLanguage,
                originalName,
                originalTitle,
                overview,
                posterPath,
                releaseDate,
                title,
                video,
                voteAverage,
                voteCount
            )
        }
    }
}