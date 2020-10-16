package com.webslinger.portfolio.moviemania.application.di.app

import com.webslinger.portfolio.moviemania.application.di.infrastructure.DatabaseModule
import com.webslinger.portfolio.moviemania.application.di.infrastructure.NetworkModule
import com.webslinger.portfolio.moviemania.application.di.data.RepositoryModule
import com.webslinger.portfolio.moviemania.application.di.domain.UseCaseModule
import com.webslinger.portfolio.moviemania.application.di.domain.character.CharacterComponent
import com.webslinger.portfolio.moviemania.application.di.data.datasource.CacheDataSource
import com.webslinger.portfolio.moviemania.application.di.data.datasource.LocalDataSourceModule
import com.webslinger.portfolio.moviemania.application.di.data.datasource.RemoteDataSourceModule
import com.webslinger.portfolio.moviemania.application.di.domain.home.HomeComponent
import com.webslinger.portfolio.moviemania.application.di.domain.movie.MovieComponent
import com.webslinger.portfolio.moviemania.application.di.domain.tvshow.TvShowComponent
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
        CacheDataSource::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface ApplicationComponent {
    fun homeComponent(): HomeComponent.Factory
    fun movieComponent(): MovieComponent.Factory
    fun tvShowComponent(): TvShowComponent.Factory
    fun characterComponent(): CharacterComponent.Factory
}