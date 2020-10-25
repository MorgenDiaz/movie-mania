package com.webslinger.portfolio.moviemania.data.datamapping.actor

import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO
import com.webslinger.portfolio.moviemania.domain.model.Actor

interface IActorMapper {
    fun networkToDbModel(networkActor: NetworkActorDTO): DBDetailedActor
    fun dbToDomainModel(dbActor: DBDetailedActor): Actor
}