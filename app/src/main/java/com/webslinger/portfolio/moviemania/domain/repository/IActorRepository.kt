package com.webslinger.portfolio.moviemania.domain.repository

import com.webslinger.portfolio.moviemania.domain.model.Actor

interface IActorRepository {
    suspend fun getActors(): List<Actor>

    suspend fun updateActors(): List<Actor>
}
