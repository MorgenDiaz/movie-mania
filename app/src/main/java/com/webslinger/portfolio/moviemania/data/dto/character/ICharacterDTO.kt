package com.webslinger.portfolio.moviemania.data.dto.character

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.dto.common.IDTO
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.CharacterSchema
import com.webslinger.portfolio.moviemania.domain.Character

interface ICharacterDTO: IDTO {
    override fun schemaToDBModel(networkModel: INetworkModel): DBCharacterKnownFor
    override fun dbModelToSchema(dbModel: IDataBaseModel): CharacterSchema
    override fun dbModelToDomain(dbModel: IDataBaseModel): Character
}