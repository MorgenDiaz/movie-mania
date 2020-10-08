package com.webslinger.portfolio.moviemania.data.dto.tvshow

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTVShow
import com.webslinger.portfolio.moviemania.data.dto.common.IDTO
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.tvshow.TVShowSchema
import com.webslinger.portfolio.moviemania.domain.TvShow

class TvShowDTO: ITvShowDTO {
    override fun schemaToDBModel(tvShowSchema: INetworkModel): DBTVShow{
        if(!TVShowSchema::class.java.isAssignableFrom(INetworkModel::class.java)){
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

    override fun dbModelToSchema(dbTvShow: IDataBaseModel): TVShowSchema {
        if(!DBTVShow::class.java.isAssignableFrom(INetworkModel::class.java)){
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

    override fun dbModelToDomain(dbModel: IDataBaseModel): TvShow {
        TODO("Not yet implemented")
    }

}