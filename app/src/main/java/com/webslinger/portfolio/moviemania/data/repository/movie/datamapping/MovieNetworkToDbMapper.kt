package com.webslinger.portfolio.moviemania.data.repository.movie.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.networking.model.movie.NetworkMovie

class MovieNetworkToDbMapper: IMovieNetworkToDbMapper {
    override fun map(input: NetworkMovie): DBMovie {
        input.apply {
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
}