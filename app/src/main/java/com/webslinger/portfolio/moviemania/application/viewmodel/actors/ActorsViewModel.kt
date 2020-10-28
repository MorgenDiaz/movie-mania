package com.webslinger.portfolio.moviemania.application.viewmodel.actors

import android.util.Log
import androidx.lifecycle.*
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import androidx.lifecycle.viewModelScope
import com.webslinger.portfolio.moviemania.domain.model.Actor
import com.webslinger.portfolio.moviemania.domain.usecase.actor.GetActorsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.actor.UpdateActorsUseCase
import kotlinx.coroutines.launch

class ActorsViewModel(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase,
    private val screenStateController: ActorsScreenStateController,
    val tmdbImageLoader: TmdbImageLoader
) : ViewModel() {

    private val _actors: MutableLiveData<List<Actor>> = MutableLiveData()
    val actors: LiveData<List<Actor>>
        get() = _actors

    fun retrieveActors(){
        if(screenStateController.isRetrievingData())
            return

        screenStateController.setStateRetrievingData()

        viewModelScope.launch {
            _actors.value = getActorsUseCase.execute()
            screenStateController.setStateIdle()
        }

    }

    fun updateActors(){
        if(screenStateController.isRetrievingData())
            return

        screenStateController.setStateRetrievingData()

        viewModelScope.launch{
            _actors.value = updateActorsUseCase.execute()
            screenStateController.setStateIdle()
        }
    }

}