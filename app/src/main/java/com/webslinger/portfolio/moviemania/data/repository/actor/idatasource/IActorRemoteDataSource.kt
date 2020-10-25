package com.webslinger.portfolio.moviemania.data.repository.actor.idatasource

import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO

interface IActorRemoteDataSource {
    suspend fun getActors(): List<NetworkActorDTO>
}
