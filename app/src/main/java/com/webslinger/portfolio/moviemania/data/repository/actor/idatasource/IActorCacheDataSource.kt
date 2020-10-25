package com.webslinger.portfolio.moviemania.data.repository.actor.idatasource

import com.webslinger.portfolio.moviemania.domain.model.Actor

interface IActorCacheDataSource {
    fun getActors(): List<Actor>
    fun updateActors(actors: List<Actor>)
}
