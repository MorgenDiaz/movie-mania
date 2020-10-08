package com.webslinger.portfolio.moviemania.domain

class GetTvShowsUseCase(private val tvShowRepository: ITvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}