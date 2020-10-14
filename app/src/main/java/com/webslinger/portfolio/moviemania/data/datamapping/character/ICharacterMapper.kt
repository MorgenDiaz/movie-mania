package com.webslinger.portfolio.moviemania.data.datamapping.character

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacter
import com.webslinger.portfolio.moviemania.domain.Character

interface ICharacterMapper {
    fun networkToDbModel(networkCharacter: NetworkCharacter): DBCharacterKnownFor
    fun dbToDomainModel(dbCharacter: DBCharacterKnownFor): Character
}