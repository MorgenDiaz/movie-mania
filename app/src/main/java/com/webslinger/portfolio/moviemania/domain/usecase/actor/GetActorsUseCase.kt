package com.webslinger.portfolio.moviemania.domain.usecase.actor

import com.webslinger.portfolio.moviemania.domain.model.Actor
import com.webslinger.portfolio.moviemania.domain.repository.IActorRepository

class GetActorsUseCase(private val actorRepository: IActorRepository) {
    suspend fun execute(): List<Actor> = actorRepository.getActors()
}