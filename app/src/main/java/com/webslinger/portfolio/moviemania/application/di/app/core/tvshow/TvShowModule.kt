package com.webslinger.portfolio.moviemania.application.di.app.core.tvshow

import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowsScreenStateController
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase,
        tmdbImageLoader: TmdbImageLoader
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase,
            TvShowsScreenStateController(),
            tmdbImageLoader
        )
    }
}