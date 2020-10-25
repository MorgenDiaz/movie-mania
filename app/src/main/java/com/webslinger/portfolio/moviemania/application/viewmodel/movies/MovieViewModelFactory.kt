package com.webslinger.portfolio.moviemania.application.viewmodel.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.domain.usecase.movie.GetMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
    private val tmdbImageLoader: TmdbImageLoader
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MoviesViewModel::class.java)){
            return MoviesViewModel(
                getMoviesUseCase,
                updateMoviesUseCase,
                tmdbImageLoader
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}