package com.webslinger.portfolio.moviemania.application.di.domain

import com.webslinger.portfolio.moviemania.data.repository.character.CharacterRepository
import com.webslinger.portfolio.moviemania.data.repository.movie.MovieRepository
import com.webslinger.portfolio.moviemania.data.repository.tvshow.TvShowRepository
import com.webslinger.portfolio.moviemania.domain.usecase.character.GetCharactersUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.character.UpdateCharactersUseCase
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
    fun provideGetCharactersUseCase(charactersRepository: CharacterRepository): GetCharactersUseCase{
        return GetCharactersUseCase(charactersRepository)
    }

    @Provides
    fun provideUpdateCharactersUseCase(charactersRepository: CharacterRepository): UpdateCharactersUseCase{
        return UpdateCharactersUseCase(charactersRepository)
    }
}