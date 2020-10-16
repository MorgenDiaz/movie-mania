package com.webslinger.portfolio.moviemania.application.di.data.datasource

import com.webslinger.portfolio.moviemania.data.networking.endpoints.CharacterService
import com.webslinger.portfolio.moviemania.data.networking.endpoints.MovieService
import com.webslinger.portfolio.moviemania.data.networking.endpoints.TvShowService
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieService: MovieService): MovieRemoteDataSource{
        return MovieRemoteDataSource(movieService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tvShowService: TvShowService): TvShowRemoteDataSource{
        return TvShowRemoteDataSource(tvShowService, apiKey)
    }

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(characterService: CharacterService): CharacterRemoteDataSource{
        return CharacterRemoteDataSource(characterService, apiKey)
    }
}