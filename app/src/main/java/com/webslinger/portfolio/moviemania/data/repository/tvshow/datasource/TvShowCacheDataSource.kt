package com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource

import com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource.ITvShowCacheDataSource
import com.webslinger.portfolio.moviemania.domain.TvShow

class TvShowCacheDataSource: ITvShowCacheDataSource {
    private var cachedTvShows: MutableList<TvShow> = mutableListOf()

    override fun getTvShows(): List<TvShow> {
        return cachedTvShows
    }

    override fun updateTvShows(tvShows: List<TvShow>) {
        cachedTvShows.clear()
        cachedTvShows.addAll(tvShows)
    }
}