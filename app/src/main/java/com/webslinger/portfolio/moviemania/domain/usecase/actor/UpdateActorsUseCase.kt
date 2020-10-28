package com.webslinger.portfolio.moviemania.domain.usecase.actor

import com.webslinger.portfolio.moviemania.domain.model.Actor
import com.webslinger.portfolio.moviemania.domain.repository.IActorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateActorsUseCase(private val actorRepository: IActorRepository) {
    suspend fun execute(): List<Actor> {
        return withContext(Dispatchers.IO){
            actorRepository.updateActors()
        }
    }
}