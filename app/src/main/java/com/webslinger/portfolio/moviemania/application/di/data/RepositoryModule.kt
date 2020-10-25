package com.webslinger.portfolio.moviemania.application.di.data

import com.webslinger.portfolio.moviemania.data.repository.actor.ActorRepository
import com.webslinger.portfolio.moviemania.data.repository.actor.datasource.ActorCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.actor.datasource.ActorLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.actor.datasource.ActorRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.ActorListMapper
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
        movieCacheDataSource: MovieCahceDataSource,
        movieListMapper: MovieListMapper
    ): MovieRepository{
        return MovieRepository(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource,
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
    fun provideActorRepository(
        characterRemoteDataSource: ActorRemoteDataSource,
        actorLocalDataSource: ActorLocalDataSource,
        actorCacheDataSource: ActorCacheDataSource,
        characterListMapper: ActorListMapper
    ): ActorRepository{
        return ActorRepository(
            characterRemoteDataSource,
            actorLocalDataSource,
            actorCacheDataSource,
            characterListMapper
        )
    }
}