package com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowListMapper
import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowMapper
import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow
import com.webslinger.portfolio.moviemania.domain.TvShow

class TvShowListMapper(
    private val tvShowMapper: ITvShowMapper
): ITvShowListMapper {
    override fun networkToDbModel(networkTVShows: List<NetworkTVShow>): List<DBTvShow> {
        return networkTVShows.map {
            tvShowMapper.networkToDbModel(it)
        }
    }

    override fun dbToDomainModel(dbTvShows: List<DBTvShow>): List<TvShow> {
        return dbTvShows.map {
            tvShowMapper.dbToDomainModel(it)
        }
    }
}