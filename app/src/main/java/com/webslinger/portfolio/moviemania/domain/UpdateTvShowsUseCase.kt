package com.webslinger.portfolio.moviemania.domain

class UpdateTvShowsUseCase(private val tvShowRepository: ITvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}