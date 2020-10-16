package com.webslinger.portfolio.moviemania.application.viewmodel.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.webslinger.portfolio.moviemania.domain.TvShow
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows(): LiveData<List<TvShow>?>{
        return liveData {
            val tvShows = getTvShowsUseCase.execute()
            emit(tvShows)
        }
    }

    fun updateTvShows(): LiveData<List<TvShow>?>{
        return liveData {
            val tvShows = updateTvShowsUseCase.execute()
            emit(tvShows)
        }
    }
}