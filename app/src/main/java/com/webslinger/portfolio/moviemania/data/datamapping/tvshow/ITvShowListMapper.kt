package com.webslinger.portfolio.moviemania.data.datamapping.tvshow

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow
import com.webslinger.portfolio.moviemania.domain.model.TvShow

interface ITvShowListMapper {
    fun networkToDbModel(networkTVShows: List<NetworkTVShow>): List<DBTvShow>
    fun dbToDomainModel(dbTvShows: List<DBTvShow>): List<TvShow>
}