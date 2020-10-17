package com.webslinger.portfolio.moviemania.application.di.app

import com.webslinger.portfolio.moviemania.application.di.data.datamapping.MovieDataMappingModule
import com.webslinger.portfolio.moviemania.application.di.infrastructure.DatabaseModule
import com.webslinger.portfolio.moviemania.application.di.infrastructure.NetworkModule
import com.webslinger.portfolio.moviemania.application.di.data.RepositoryModule
import com.webslinger.portfolio.moviemania.application.di.data.datamapping.CharacterDataMappingModule
import com.webslinger.portfolio.moviemania.application.di.data.datamapping.KnownForDataMappingModule
import com.webslinger.portfolio.moviemania.application.di.data.datamapping.TvShowDataMappingModule
import com.webslinger.portfolio.moviemania.application.di.domain.UseCaseModule
import com.webslinger.portfolio.moviemania.application.di.domain.character.CharacterComponent
import com.webslinger.portfolio.moviemania.application.di.data.datasource.CacheDataSourceModule
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
        CacheDataSourceModule::class,
        MovieDataMappingModule::class,
        TvShowDataMappingModule::class,
        KnownForDataMappingModule::class,
        CharacterDataMappingModule::class,
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