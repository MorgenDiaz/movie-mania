package com.webslinger.portfolio.moviemania.application.viewmodel.tvshows

class TvShowsScreenStateController {
    private var state: TvShowsScreenState = TvShowsScreenState.IDLE

    fun setStateRetrievingData(){
        state = TvShowsScreenState.RETRIEVING_DATA
    }

    fun setStateIdle(){
        state = TvShowsScreenState.IDLE
    }

    fun isRetrievingData(): Boolean{
        return state == TvShowsScreenState.RETRIEVING_DATA
    }

    fun isIdle(): Boolean{
        return state == TvShowsScreenState.IDLE
    }

    private enum class TvShowsScreenState{
        IDLE,
        RETRIEVING_DATA
    }
}