package com.webslinger.portfolio.moviemania.data.dto.movie

import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.dto.common.IDTO
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieSchema
import com.webslinger.portfolio.moviemania.domain.Movie

interface IMovieDTO: IDTO {
    override fun schemaToDBModel(networkModel: INetworkModel): DBMovie
    override fun dbModelToSchema(dbModel: IDataBaseModel): MovieSchema
    override fun dbModelToDomain(dbModel: IDataBaseModel): Movie

}