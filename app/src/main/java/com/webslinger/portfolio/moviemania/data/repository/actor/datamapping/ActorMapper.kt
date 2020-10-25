package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO
import com.webslinger.portfolio.moviemania.domain.model.Actor

class ActorMapper(
    private val networkToDbMapper: IActorNetworkToDbMapper,
    private val dbToDomainMapper: IActorDbToDomainMapper
    ): IActorMapper {
    override fun networkToDbModel(networkActor: NetworkActorDTO): DBDetailedActor {
        return networkToDbMapper.map(networkActor)
    }

    override fun dbToDomainModel(dbActor: DBDetailedActor): Actor {
        return dbToDomainMapper.map(dbActor)
    }

}