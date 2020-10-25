package com.webslinger.portfolio.moviemania.application.di.app.core.movie

import com.webslinger.portfolio.moviemania.presentation.movies.MoviesFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieComponent {
    fun inject(moviesFragment: MoviesFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieComponent
    }
}