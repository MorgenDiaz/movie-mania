package com.webslinger.portfolio.moviemania.data.repository.movie.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.domain.model.Movie

class MovieDbToDomainMapper: IMovieDbToDomainMapper {
    override fun map(input: DBMovie): Movie {
        input.apply {
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