package com.webslinger.portfolio.moviemania.data.repository.actor.datasource

import com.webslinger.portfolio.moviemania.data.db.actor.ActorDAO
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.data.repository.actor.idatasource.IActorLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActorLocalDataSource(private val actorDAO: ActorDAO): IActorLocalDataSource {
    override suspend fun saveActors(actors: List<DBDetailedActor>) {
        CoroutineScope(Dispatchers.IO).launch {
            actorDAO.saveActors(actors)
        }
    }

    override suspend fun getActors(): List<DBDetailedActor> {
        return actorDAO.getAllActors()
    }

    override suspend fun clearActors() {
        CoroutineScope(Dispatchers.IO).launch {
            actorDAO.deleteAllActors()
        }
    }
}