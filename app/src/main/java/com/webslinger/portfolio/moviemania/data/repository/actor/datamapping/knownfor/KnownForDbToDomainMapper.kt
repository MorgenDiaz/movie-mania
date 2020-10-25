package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.knownfor

import com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBKnownFor
import com.webslinger.portfolio.moviemania.domain.model.KnownFor

class KnownForDbToDomainMapper: IKnownForDbToDomainMapper {
    override fun map(input: DBKnownFor): KnownFor {
        input.apply {
            return KnownFor(
                adult,
                backdropPath,
                firstAirDate,
                genreIds,
                id,
                actorId,
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
}