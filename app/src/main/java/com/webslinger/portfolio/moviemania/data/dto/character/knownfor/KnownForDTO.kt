package com.webslinger.portfolio.moviemania.data.dto.character.knownfor

import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.KnownForSchema
import com.webslinger.portfolio.moviemania.domain.KnownFor

class KnownForDTO(private val characterId: Int) : IKnownForDTO {
    override fun schemaToDBModel(networkModel: INetworkModel): DBKnownFor {
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

    override fun dbModelToSchema(dbModel: IDataBaseModel): KnownForSchema {
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

    override fun dbModelToDomain(dbModel: IDataBaseModel): KnownFor {
        TODO("Not yet implemented")
    }
}