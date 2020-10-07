package com.webslinger.portfolio.moviemania.data.dto

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.dto.common.DTO
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieSchema

class MovieDTO : DTO {

    override fun schemaToDBModel(movieSchema: NetworkModel): DBMovie{
        if(!MovieSchema::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid movie schema.")
        }

        (movieSchema as MovieSchema).apply {
            return DBMovie(
                adult,
                backdropPath,
                genreIds,
                id,
                originalLanguage,
                originalTitle,
                overview,
                popularity,
                posterPath,
                releaseDate,
                title,
                video,
                voteAverage,
                voteCount
            )
        }
    }

    override fun dbModelToSchema(dbMovie: DataBaseModel): MovieSchema{
        if(!DBMovie::class.java.isAssignableFrom(DataBaseModel::class.java)){
            throw IllegalArgumentException("Invalid movie database model.")
        }

        (dbMovie as DBMovie).apply {
            return MovieSchema(
                adult,
                backdropPath,
                genreIds,
                id,
                originalLanguage,
                originalTitle,
                overview,
                popularity,
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