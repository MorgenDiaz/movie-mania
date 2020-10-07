package com.webslinger.portfolio.moviemania.data.dto

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTVShow
import com.webslinger.portfolio.moviemania.data.dto.common.DTO
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.tvshow.TVShowSchema

class TvShowDTO: DTO {
    override fun schemaToDBModel(tvShowSchema: NetworkModel): DBTVShow{
        if(!TVShowSchema::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid tv show schema.")
        }

        (tvShowSchema as TVShowSchema).apply {
            return DBTVShow(
                backdropPath,
                firstAirDate,
                genreIds,
                id,
                name,
                originCountry,
                originalLanguage,
                originalName,
                overview,
                popularity,
                posterPath,
                voteAverage,
                voteCount
            )
        }
    }

    override fun dbModelToSchema(dbTvShow: DataBaseModel): TVShowSchema {
        if(!DBTVShow::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid tv show database model.")
        }

        (dbTvShow as DBTVShow).apply {
            return TVShowSchema(
                backdropPath,
                firstAirDate,
                genreIds,
                id,
                name,
                originCountry,
                originalLanguage,
                originalName,
                overview,
                popularity,
                posterPath,
                voteAverage,
                voteCount
            )
        }
    }

}