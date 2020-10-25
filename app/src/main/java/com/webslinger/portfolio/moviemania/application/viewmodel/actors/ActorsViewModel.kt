package com.webslinger.portfolio.moviemania.application.viewmodel.actors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.domain.model.Actor
import com.webslinger.portfolio.moviemania.domain.usecase.actor.GetActorsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.actor.UpdateActorsUseCase
import kotlinx.coroutines.Dispatchers

class ActorsViewModel(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase,
    val tmdbImageLoader: TmdbImageLoader
) : ViewModel() {

    fun getActors(): LiveData<List<Actor>>{
        return liveData(Dispatchers.IO) {
            val actors = getActorsUseCase.execute()
            emit(actors)
        }
    }

    fun updateActors(): LiveData<List<Actor>>{
        return liveData {
            val actors = updateActorsUseCase.execute()
            emit(actors)
        }
    }
}