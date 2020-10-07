package com.webslinger.portfolio.moviemania.data.dto.common

interface DTO {
    fun schemaToDBModel(networkModel: NetworkModel): DataBaseModel
    fun dbModelToSchema(dbModel: DataBaseModel): NetworkModel
}