package com.webslinger.portfolio.moviemania.application.di.app.core.tvshow

import com.webslinger.portfolio.moviemania.presentation.tvshows.TvShowsFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowComponent {
    fun inject(tvShowsFragment: TvShowsFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowComponent
    }
}