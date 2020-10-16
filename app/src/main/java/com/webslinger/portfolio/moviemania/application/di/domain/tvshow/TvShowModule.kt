package com.webslinger.portfolio.moviemania.application.di.domain.tvshow

import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowViewModelFactory
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}