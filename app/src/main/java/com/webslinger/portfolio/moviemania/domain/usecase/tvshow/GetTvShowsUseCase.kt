package com.webslinger.portfolio.moviemania.domain.usecase.tvshow

import com.webslinger.portfolio.moviemania.domain.model.TvShow
import com.webslinger.portfolio.moviemania.domain.repository.ITvShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetTvShowsUseCase(private val tvShowRepository: ITvShowRepository) {
    suspend fun execute():List<TvShow>{
        return withContext(Dispatchers.IO){
            tvShowRepository.getTvShows()
        }
    }
}