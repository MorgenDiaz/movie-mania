package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.details.IDetailsNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBActor
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO

class ActorNetworkToDbMapper(
    private val knownForMapper: IKnownForMapper,
    private val detailsMapper: IDetailsNetworkToDbMapper
): IActorNetworkToDbMapper {
    override fun map(input: NetworkActorDTO): DBDetailedActor {
        input.apply {
            return DBDetailedActor(
                DBActor(
                    input.networkActor.adult,
                    input.networkActor.gender,
                    input.networkActor.id,
                    input.networkActor.knownForDepartment,
                    input.networkActor.name,
                    input.networkActor.popularity,
                    input.networkActor.profilePath
                ),
                input.networkActor.networkKnownFor.map {
                    knownForMapper.networkToDbModel(it, input.networkActor.id)
                },
                detailsMapper.map(input.actorDetails)
            )
        }
    }
}