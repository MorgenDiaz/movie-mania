package com.webslinger.portfolio.moviemania.application.viewmodel.movies

import androidx.lifecycle.*
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.domain.usecase.movie.GetMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
    private val screenStateController: MoviesScreenStateController,
    val tmdbImageLoader: TmdbImageLoader
) : ViewModel() {
    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>>
        get() {
            return _movies
        }

    fun retrieveMovies(){
        if(screenStateController.isRetrievingData())
            return

        screenStateController.setStateRetrievingData()

        viewModelScope.launch{
            _movies.value = getMoviesUseCase.execute()
            screenStateController.setStateIdle()
        }
    }

    fun updateMovies(){
        if(screenStateController.isRetrievingData())
            return

        screenStateController.setStateRetrievingData()

        viewModelScope.launch {
            _movies.value = updateMoviesUseCase.execute()
            screenStateController.setStateIdle()
        }
    }
}