package com.webslinger.portfolio.moviemania.application.di.app

import android.content.Context
import com.webslinger.portfolio.moviemania.application.di.app.core.actor.ActorComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.tvshow.TvShowComponent
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [
        HomeComponent::class,
        MovieComponent::class,
        TvShowComponent::class,
        ActorComponent::class
    ]
)
class ApplicationModule(private val context: Context) {
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}