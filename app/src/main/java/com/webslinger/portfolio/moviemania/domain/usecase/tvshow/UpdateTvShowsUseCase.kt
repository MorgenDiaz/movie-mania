package com.webslinger.portfolio.moviemania.domain.usecase.tvshow

import com.webslinger.portfolio.moviemania.domain.TvShow
import com.webslinger.portfolio.moviemania.domain.repository.ITvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: ITvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}