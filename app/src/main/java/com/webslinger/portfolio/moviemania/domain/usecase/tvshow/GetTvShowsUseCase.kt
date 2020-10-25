package com.webslinger.portfolio.moviemania.domain.usecase.tvshow

import com.webslinger.portfolio.moviemania.domain.model.TvShow
import com.webslinger.portfolio.moviemania.domain.repository.ITvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: ITvShowRepository) {
    suspend fun execute():List<TvShow> = tvShowRepository.getTvShows()
}