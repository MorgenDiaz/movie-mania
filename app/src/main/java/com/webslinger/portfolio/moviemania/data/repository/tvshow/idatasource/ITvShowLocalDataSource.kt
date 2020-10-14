package com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow

interface ITvShowLocalDataSource {
    suspend fun saveTvShows(dbTvShows: List<DBTvShow>)
    suspend fun getTvShows(): List<DBTvShow>
    suspend fun clearTvShows()
}
