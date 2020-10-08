package com.webslinger.portfolio.moviemania.domain

interface ITvShowRepository {
    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}
