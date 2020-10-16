package com.webslinger.portfolio.moviemania.application.di.app

import android.content.Context
import com.webslinger.portfolio.moviemania.application.di.domain.character.CharacterComponent
import com.webslinger.portfolio.moviemania.application.di.domain.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.domain.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.domain.tvshow.TvShowComponent
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [
        HomeComponent::class,
        MovieComponent::class,
        TvShowComponent::class,
        CharacterComponent::class
    ]
)
class ApplicationModule(private val context: Context) {
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}