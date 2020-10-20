package com.webslinger.portfolio.moviemania.application.viewmodel.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.webslinger.portfolio.moviemania.domain.Movie
import com.webslinger.portfolio.moviemania.domain.usecase.movie.GetMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies(): LiveData<List<Movie>?>{
        return liveData{
            val movies = getMoviesUseCase.execute()
            emit(movies)
        }
    }

    fun updateMovies(): LiveData<List<Movie>>{
        return liveData {
            val movies = updateMoviesUseCase.execute()
            emit(movies)
        }
    }
}