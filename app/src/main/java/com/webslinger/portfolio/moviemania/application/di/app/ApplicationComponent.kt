package com.webslinger.portfolio.moviemania.application.di.app

import com.webslinger.portfolio.moviemania.application.di.infrastructure.DatabaseModule
import com.webslinger.portfolio.moviemania.application.di.infrastructure.NetworkModule
import com.webslinger.portfolio.moviemania.application.di.data.RepositoryModule
import com.webslinger.portfolio.moviemania.application.di.app.core.actor.ActorComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.common.UtilityModule
import com.webslinger.portfolio.moviemania.application.di.data.datasource.CacheDataSourceModule
import com.webslinger.portfolio.moviemania.application.di.data.datasource.LocalDataSourceModule
import com.webslinger.portfolio.moviemania.application.di.data.datasource.RemoteDataSourceModule
import com.webslinger.portfolio.moviemania.application.di.app.core.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.app.core.tvshow.TvShowComponent
import com.webslinger.portfolio.moviemania.application.di.data.datamapping.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        CacheDataSourceModule::class,
        MovieDataMappingModule::class,
        TvShowDataMappingModule::class,
        KnownForDataMappingModule::class,
        DetailsDataMappingModule::class,
        ActorDataMappingModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        UtilityModule::class
    ]
)
interface ApplicationComponent {
    fun homeComponent(): HomeComponent.Factory
    fun movieComponent(): MovieComponent.Factory
    fun tvShowComponent(): TvShowComponent.Factory
    fun actorComponent(): ActorComponent.Factory
}