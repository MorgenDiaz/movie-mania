package com.webslinger.portfolio.moviemania.data.datamapping.tvshow

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow
import com.webslinger.portfolio.moviemania.domain.TvShow

interface ITvShowMapper {
    fun networkToDbModel(networkTVShow: NetworkTVShow): DBTvShow
    fun dbToDomainModel(dbTvShow: DBTvShow): TvShow
}