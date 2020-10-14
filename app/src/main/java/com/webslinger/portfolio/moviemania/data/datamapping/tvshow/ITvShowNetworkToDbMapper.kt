package com.webslinger.portfolio.moviemania.data.datamapping.tvshow

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.networking.model.tvshow.NetworkTVShow

interface ITvShowNetworkToDbMapper: IDataMapper<NetworkTVShow, DBTvShow>