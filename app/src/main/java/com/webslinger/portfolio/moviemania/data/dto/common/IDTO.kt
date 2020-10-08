package com.webslinger.portfolio.moviemania.data.dto.common

import com.webslinger.portfolio.moviemania.domain.IDomainModel

interface IDTO {
    fun schemaToDBModel(networkModel: INetworkModel): IDataBaseModel
    fun dbModelToSchema(dbModel: IDataBaseModel): INetworkModel
    fun dbModelToDomain(dbModel: IDataBaseModel): IDomainModel
}