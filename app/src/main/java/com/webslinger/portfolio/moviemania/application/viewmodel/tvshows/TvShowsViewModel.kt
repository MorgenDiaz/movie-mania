package com.webslinger.portfolio.moviemania.application.viewmodel.tvshows

import androidx.lifecycle.*
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.domain.model.TvShow
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase
import kotlinx.coroutines.launch

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
    private val screenStateController: TvShowsScreenStateController,
    val tmdbImageLoader: TmdbImageLoader
) : ViewModel() {
    private val _tvShows: MutableLiveData<List<TvShow>> = MutableLiveData()
    val tvShows: LiveData<List<TvShow>>
        get() {
            return _tvShows
        }

    fun retrieveTvShows() {
        if (screenStateController.isRetrievingData())
            return

        screenStateController.setStateRetrievingData()

        viewModelScope.launch {
            _tvShows.value = getTvShowsUseCase.execute()
            screenStateController.setStateIdle()
        }
    }

    fun updateTvShows() {
        if (screenStateController.isRetrievingData())
            return

        screenStateController.setStateRetrievingData()

        viewModelScope.launch {
            _tvShows.value = updateTvShowsUseCase.execute()
            screenStateController.setStateIdle()
        }

    }
}