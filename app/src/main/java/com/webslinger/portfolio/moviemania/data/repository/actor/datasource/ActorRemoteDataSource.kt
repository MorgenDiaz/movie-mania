package com.webslinger.portfolio.moviemania.data.repository.actor.datasource

import android.util.Log
import com.webslinger.portfolio.moviemania.data.networking.endpoints.ActorService
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDetails
import com.webslinger.portfolio.moviemania.data.repository.actor.idatasource.IActorRemoteDataSource

class ActorRemoteDataSource(private val actorService: ActorService, private val apiKey: String):
    IActorRemoteDataSource {
    override suspend fun getActors(): List<NetworkActorDTO>{
        val popularActors = getPopularActors()
        return createActorDTOs(popularActors)
    }

    private suspend fun getPopularActors(): List<NetworkActor>{
        var networkActors: List<NetworkActor> = listOf()

        try {
            val response = actorService.getPopular(apiKey)
            val responseBody = response.body()

            responseBody?.let {
                networkActors = it.networkActors
            }
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading actors from network.")
        }

        return networkActors
    }

    private suspend fun createActorDTOs(popularActors: List<NetworkActor>): List<NetworkActorDTO> {
        val actors: MutableList<NetworkActorDTO> = mutableListOf()

        popularActors.forEach() {
            val actorDetails = getActorDetails(it.id)
            actors.add(
                NetworkActorDTO(
                    it,
                    actorDetails
                )
            )
        }

        return actors
    }

    private suspend fun getActorDetails(actorId: Int): NetworkActorDetails{
        var networkActorDetails = NetworkActorDetails.EMPTY_ACTOR

        try {
            val response = actorService.getDetails(actorId, apiKey)
            val responseBody = response.body()

            responseBody?.let {
                networkActorDetails = it
            }
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading actor details from network.")
        }

        return networkActorDetails
    }
}