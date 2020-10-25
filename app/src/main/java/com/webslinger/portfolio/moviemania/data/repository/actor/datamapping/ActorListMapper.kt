package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorListMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO
import com.webslinger.portfolio.moviemania.domain.model.Actor

class ActorListMapper(private val actorMapper: IActorMapper): IActorListMapper {
    override fun networkToDbModel(networkActors: List<NetworkActorDTO>): List<DBDetailedActor> {
        return networkActors.map {
            actorMapper.networkToDbModel(it)
        }
    }

    override fun dbToDomainModel(dbActors: List<DBDetailedActor>): List<Actor> {
        return dbActors.map {
            actorMapper.dbToDomainModel(it)
        }
    }
}