package com.webslinger.portfolio.moviemania.application.viewmodel.actors

class ActorsScreenStateController() {
    private var state: ActorsScreenState = ActorsScreenState.IDLE

    fun setStateRetrievingData(){
        state = ActorsScreenState.RETRIEVING_DATA
    }

    fun setStateIdle(){
        state = ActorsScreenState.IDLE
    }

    fun isRetrievingData(): Boolean{
        return state == ActorsScreenState.RETRIEVING_DATA
    }

    fun isIdle(): Boolean{
        return state == ActorsScreenState.IDLE
    }

    private enum class ActorsScreenState{
        IDLE,
        RETRIEVING_DATA
    }
}