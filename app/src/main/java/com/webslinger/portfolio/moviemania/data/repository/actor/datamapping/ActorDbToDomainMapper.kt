package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.domain.model.Actor

class ActorDbToDomainMapper(private val knownForMapper: IKnownForMapper): IActorDbToDomainMapper {
    override fun map(input: DBDetailedActor): Actor {
        input.apply {
            return Actor(
                actor.adult,
                actor.gender,
                actor.id,
                knownFor.map {
                    knownForMapper.dbToDomainModel(it)
                },
                actor.knownForDepartment,
                actor.name,
                details.biography,
                actor.popularity,
                actor.profilePath
            )
        }
    }
}