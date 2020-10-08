package com.webslinger.portfolio.moviemania.data.dto.movie

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieSchema
import com.webslinger.portfolio.moviemania.domain.Movie

class MovieDTO : IMovieDTO {

    override fun schemaToDBModel(movieSchema: INetworkModel): DBMovie{
        if(!MovieSchema::class.java.isAssignableFrom(movieSchema::class.java)){
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

    override fun dbModelToSchema(dbMovie: IDataBaseModel): MovieSchema{
        if(!DBMovie::class.java.isAssignableFrom(IDataBaseModel::class.java)){
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

    override fun dbModelToDomain(dbModel: IDataBaseModel): Movie {
        if(!DBMovie::class.java.isAssignableFrom(dbModel::class.java)){
            throw IllegalArgumentException("Invalid movie database model.")
        }

        (dbModel as DBMovie).apply {
            return Movie(
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