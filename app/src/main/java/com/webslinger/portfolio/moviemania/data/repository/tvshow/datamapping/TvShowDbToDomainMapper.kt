package com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.domain.model.TvShow

class TvShowDbToDomainMapper: ITvShowDbToDomainMapper {
    override fun map(input: DBTvShow): TvShow {
        input.apply {
            return TvShow(
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