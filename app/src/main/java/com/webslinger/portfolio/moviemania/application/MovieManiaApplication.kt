package com.webslinger.portfolio.moviemania.application

import android.app.Application
import com.webslinger.portfolio.moviemania.BuildConfig
import com.webslinger.portfolio.moviemania.application.di.Injector
import com.webslinger.portfolio.moviemania.application.di.app.ApplicationModule
import com.webslinger.portfolio.moviemania.application.di.app.DaggerApplicationComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.actor.ActorComponent
import com.webslinger.portfolio.moviemania.application.di.data.datasource.RemoteDataSourceModule
import com.webslinger.portfolio.moviemania.application.di.app.core.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.tvshow.TvShowComponent

class MovieManiaApplication: Application(), Injector {
    private val applicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.THE_MOVIEDB_API_KEY))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun createHomeComponent(): HomeComponent {
        return applicationComponent.homeComponent().create()
    }

    override fun createMovieComponent(): MovieComponent {
        return applicationComponent.movieComponent().create()
    }

    override fun createTvShowComponent(): TvShowComponent {
        return applicationComponent.tvShowComponent().create()
    }

    override fun createActorComponent(): ActorComponent {
        return applicationComponent.actorComponent().create()
    }
}