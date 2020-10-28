package com.webslinger.portfolio.moviemania.data.repository.actor

import android.util.Log
import com.webslinger.portfolio.moviemania.data.datamapping.actor.IActorListMapper
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO
import com.webslinger.portfolio.moviemania.data.repository.actor.idatasource.IActorLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.actor.idatasource.IActorRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.actor.idatasource.IActorCacheDataSource
import com.webslinger.portfolio.moviemania.domain.model.Actor
import com.webslinger.portfolio.moviemania.domain.repository.IActorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActorRepository(
    private val remoteDataSource: IActorRemoteDataSource,
    private val localDataSource: IActorLocalDataSource,
    private val cacheDataSource: IActorCacheDataSource,
    private val actorListMapper: IActorListMapper
) : IActorRepository {

    override suspend fun getActors(): List<Actor> {
        val cachedActors = cacheDataSource.getActors()

        if (cachedActors.isEmpty()) {
            val dbActors = getActorsFromDb()

            if (dbActors.isEmpty()) {
                downloadActors()
                return cacheDataSource.getActors()
            }

            cacheDataSource.updateActors(dbActors)
            return dbActors
        }

        return cachedActors
    }

    override suspend fun updateActors(): List<Actor> {
        downloadActors()
        return cacheDataSource.getActors()
    }

    private suspend fun downloadActors() {
        val networkActors = getActorsFromNetwork()

        val dbActors = actorListMapper.networkToDbModel(networkActors)
        localDataSource.saveActors(dbActors)

        val actors = actorListMapper.dbToDomainModel(dbActors)
        cacheDataSource.updateActors(actors)
    }

    private suspend fun getActorsFromNetwork(): List<NetworkActorDTO> {
        return remoteDataSource.getActors()
    }

    private suspend fun getActorsFromDb(): List<Actor> {
        var actors: List<Actor> = listOf()

        try {
            val dbActors = localDataSource.getActors()
            actors = actorListMapper.dbToDomainModel(dbActors)
        } catch (e: Exception) {
            Log.i("MovieMania", "Error retrieving actors from database.")
        }

        return actors
    }
}