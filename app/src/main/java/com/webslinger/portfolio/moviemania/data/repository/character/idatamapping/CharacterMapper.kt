package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping

import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacter
import com.webslinger.portfolio.moviemania.domain.Character

class CharacterMapper(
    private val networkToDbMapper: ICharacterNetworkToDbMapper,
    private val dbToDomainMapper: ICharacterDbToDomainMapper
    ): ICharacterMapper {
    override fun networkToDbModel(networkCharacter: NetworkCharacter): DBCharacterKnownFor {
        return networkToDbMapper.map(networkCharacter)
    }

    override fun dbToDomainModel(dbCharacter: DBCharacterKnownFor): Character {
        return dbToDomainMapper.map(dbCharacter)
    }

}