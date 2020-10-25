package com.webslinger.portfolio.moviemania.application.di

import com.webslinger.portfolio.moviemania.application.di.app.core.actor.ActorComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.tvshow.TvShowComponent

interface Injector {
    fun createHomeComponent(): HomeComponent
    fun createMovieComponent(): MovieComponent
    fun createTvShowComponent(): TvShowComponent
    fun createActorComponent(): ActorComponent
}