package com.webslinger.portfolio.moviemania.data.repository.actor.idatasource

import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor

interface IActorLocalDataSource {
    suspend fun saveActors(actors: List<DBDetailedActor>)
    suspend fun getActors(): List<DBDetailedActor>
    suspend fun clearActors()

}
