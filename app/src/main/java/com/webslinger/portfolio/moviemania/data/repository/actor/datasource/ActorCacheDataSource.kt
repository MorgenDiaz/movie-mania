package com.webslinger.portfolio.moviemania.data.repository.actor.datasource

import com.webslinger.portfolio.moviemania.data.repository.actor.idatasource.IActorCacheDataSource
import com.webslinger.portfolio.moviemania.domain.model.Actor

class ActorCacheDataSource: IActorCacheDataSource {
    private val cachedActors: MutableList<Actor> = mutableListOf()

    override fun getActors(): List<Actor> {
        return cachedActors
    }

    override fun updateActors(actors: List<Actor>) {
        cachedActors.clear()
        cachedActors.addAll(actors)
    }
}