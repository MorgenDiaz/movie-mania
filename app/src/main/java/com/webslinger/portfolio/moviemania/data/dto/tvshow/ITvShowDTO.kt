package com.webslinger.portfolio.moviemania.data.dto.tvshow

import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTVShow
import com.webslinger.portfolio.moviemania.data.dto.common.IDTO
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.tvshow.TVShowSchema
import com.webslinger.portfolio.moviemania.domain.TvShow

interface ITvShowDTO: IDTO {
    override fun schemaToDBModel(networkModel: INetworkModel): DBTVShow
    override fun dbModelToSchema(dbModel: IDataBaseModel): TVShowSchema
    override fun dbModelToDomain(dbModel: IDataBaseModel): TvShow
}