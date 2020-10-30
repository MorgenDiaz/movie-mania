package com.webslinger.portfolio.moviemania.application.di.app

import com.webslinger.portfolio.moviemania.data.repository.actor.ActorRepository
import com.webslinger.portfolio.moviemania.data.repository.movie.MovieRepository
import com.webslinger.portfolio.moviemania.data.repository.tvshow.TvShowRepository
import com.webslinger.portfolio.moviemania.domain.usecase.actor.GetActorsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.actor.UpdateActorsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.GetMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetActorsUseCase(charactersRepository: ActorRepository): GetActorsUseCase{
        return GetActorsUseCase(charactersRepository)
    }

    @Provides
    fun provideUpdateActorsUseCase(charactersRepository: ActorRepository): UpdateActorsUseCase{
        return UpdateActorsUseCase(charactersRepository)
    }
}