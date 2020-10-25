package com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping

import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowMapper
import com.webslinger.portfolio.moviemania.data.datamapping.tvshow.ITvShowNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow
import com.webslinger.portfolio.moviemania.domain.model.TvShow

class TvShowMapper(
    private val networkToDbMapper: ITvShowNetworkToDbMapper,
    private val dbToDomainMapper: ITvShowDbToDomainMapper
): ITvShowMapper {
    override fun networkToDbModel(networkTVShow: NetworkTVShow): DBTvShow {
        return networkToDbMapper.map(networkTVShow)
    }

    override fun dbToDomainModel(dbTvShow: DBTvShow): TvShow {
        return dbToDomainMapper.map(dbTvShow)
    }
}