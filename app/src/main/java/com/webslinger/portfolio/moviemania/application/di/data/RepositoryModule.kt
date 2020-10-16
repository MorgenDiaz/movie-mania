package com.webslinger.portfolio.moviemania.application.di.data

import com.webslinger.portfolio.moviemania.data.repository.character.CharacterRepository
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterListMapper
import com.webslinger.portfolio.moviemania.data.repository.movie.MovieRepository
import com.webslinger.portfolio.moviemania.data.repository.movie.datamapping.MovieListMapper
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieCahceDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.TvShowRepository
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowListMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCahceDataSource: MovieCahceDataSource,
        movieListMapper: MovieListMapper
    ): MovieRepository{
        return MovieRepository(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCahceDataSource,
            movieListMapper
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowListMapper: TvShowListMapper
    ): TvShowRepository{
        return TvShowRepository(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource,
            tvShowListMapper
        )
    }

    @Singleton
    @Provides
    fun provideCharacterRepository(
        characterRemoteDataSource: CharacterRemoteDataSource,
        characterLocalDataSource: CharacterLocalDataSource,
        characterCacheDataSource: CharacterCacheDataSource,
        characterListMapper: CharacterListMapper
    ): CharacterRepository{
        return CharacterRepository(
            characterRemoteDataSource,
            characterLocalDataSource,
            characterCacheDataSource,
            characterListMapper
        )
    }
}