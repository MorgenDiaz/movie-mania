package com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.db.tvshow.TvShowDAO
import com.webslinger.portfolio.moviemania.data.repository.tvshow.idatasource.ITvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSource(private val tvShowDAO: TvShowDAO): ITvShowLocalDataSource {
    override suspend fun saveTvShows(dbTvShows: List<DBTvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShows(dbTvShows)
        }
    }

    override suspend fun getTvShows(): List<DBTvShow> = tvShowDAO.getAllTvShows()

    override suspend fun clearTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}