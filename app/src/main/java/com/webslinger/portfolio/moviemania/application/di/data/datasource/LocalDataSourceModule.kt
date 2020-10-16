package com.webslinger.portfolio.moviemania.application.di.data.datasource

import com.webslinger.portfolio.moviemania.data.db.character.CharacterDAO
import com.webslinger.portfolio.moviemania.data.db.movie.MovieDAO
import com.webslinger.portfolio.moviemania.data.db.tvshow.TvShowDAO
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource{
        return MovieLocalDataSource(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource{
        return TvShowLocalDataSource(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideCharacterLocalDataSource(characterDAO: CharacterDAO): CharacterLocalDataSource{
        return CharacterLocalDataSource(characterDAO)
    }
}