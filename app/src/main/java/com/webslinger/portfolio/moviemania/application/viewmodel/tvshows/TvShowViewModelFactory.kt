package com.webslinger.portfolio.moviemania.application.viewmodel.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase
import javax.inject.Inject

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TvShowsViewModel::class.java)) {
            return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}