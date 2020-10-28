package com.webslinger.portfolio.moviemania.application.viewmodel.movies

class MoviesScreenStateController {
    private var state: MoviesScreenState = MoviesScreenState.IDLE

    fun setStateRetrievingData(){
        state = MoviesScreenState.RETRIEVING_DATA
    }

    fun setStateIdle(){
        state = MoviesScreenState.IDLE
    }

    fun isRetrievingData(): Boolean{
        return state == MoviesScreenState.RETRIEVING_DATA
    }

    fun isIdle(): Boolean{
        return state == MoviesScreenState.IDLE
    }

    private enum class MoviesScreenState{
        IDLE,
        RETRIEVING_DATA
    }
}