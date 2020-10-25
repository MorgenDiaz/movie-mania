package com.webslinger.portfolio.moviemania.application.di.app.core.movie

import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MovieViewModelFactory
import com.webslinger.portfolio.moviemania.domain.usecase.movie.GetMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase,
        tmdbImageLoader: TmdbImageLoader
    ): MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase,
            tmdbImageLoader
        )
    }
}