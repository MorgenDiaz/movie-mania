package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.knownfor

import com.webslinger.portfolio.moviemania.data.db.actor.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkKnownFor

class KnownForNetworkToDbMapper (override var actorId: Int = -1): com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForNetworkToDbMapper {
    override fun map(input: NetworkKnownFor): DBKnownFor {
        input.apply {
            return DBKnownFor(
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