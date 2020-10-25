package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.details

import com.webslinger.portfolio.moviemania.data.datamapping.actor.details.IDetailsNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBActorDetails
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDetails

private const val NA = "N/A"
class DetailsNetworkToDbMapper: IDetailsNetworkToDbMapper {
    override fun map(input: NetworkActorDetails): DBActorDetails {
        input.apply {
            return DBActorDetails(
                input.adult,
                input.alsoKnownAs,
                input.biography,
                input.birthday ?: NA,
                input.deathday?: NA,
                input.gender,
                input.homepage ?: NA,
                input.id,
                input.imdbId,
                input.knownForDepartment,
                input.name,
                input.placeOfBirth,
                input.popularity,
                input.profilePath
            )
        }
    }
}