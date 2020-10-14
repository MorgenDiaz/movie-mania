package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor

import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkKnownFor

class KnownForNetworkToDbMapper (override var characterId: Int = -1): com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForNetworkToDbMapper {
    override fun map(input: NetworkKnownFor): DBKnownFor {
        input.apply {
            return DBKnownFor(
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