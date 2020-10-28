package com.webslinger.portfolio.moviemania.application.viewmodel.actors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.domain.usecase.actor.GetActorsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.actor.UpdateActorsUseCase

class ActorViewModelFactory(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase,
    private val actorsScreenStateController: ActorsScreenStateController,
    private val tmdbImageLoader: TmdbImageLoader
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ActorsViewModel::class.java)){
            return ActorsViewModel(
                getActorsUseCase,
                updateActorsUseCase,
                actorsScreenStateController,
                tmdbImageLoader
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}