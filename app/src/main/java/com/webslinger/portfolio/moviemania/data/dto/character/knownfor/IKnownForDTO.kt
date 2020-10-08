package com.webslinger.portfolio.moviemania.data.dto.character.knownfor

import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.data.dto.common.IDTO
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.KnownForSchema
import com.webslinger.portfolio.moviemania.domain.KnownFor

interface IKnownForDTO: IDTO {
    override fun schemaToDBModel(networkModel: INetworkModel): DBKnownFor
    override fun dbModelToSchema(dbModel: IDataBaseModel): KnownForSchema
    override fun dbModelToDomain(dbModel: IDataBaseModel): KnownFor
}