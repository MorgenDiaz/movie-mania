package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor

import com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.domain.KnownFor

class KnownForDbToDomainMapper: IKnownForDbToDomainMapper {
    override fun map(input: DBKnownFor): KnownFor {
        input.apply {
            return KnownFor(
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
}