package com.webslinger.portfolio.moviemania.application.di

import com.webslinger.portfolio.moviemania.application.di.domain.character.CharacterComponent
import com.webslinger.portfolio.moviemania.application.di.domain.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.domain.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.domain.tvshow.TvShowComponent

interface Injector {
    fun createHomeComponent(): HomeComponent
    fun createMovieComponent(): MovieComponent
    fun createTvShowComponent(): TvShowComponent
    fun createCharacterComponent(): CharacterComponent
}