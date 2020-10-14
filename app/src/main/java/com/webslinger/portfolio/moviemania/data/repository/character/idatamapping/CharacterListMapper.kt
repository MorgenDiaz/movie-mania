package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping

import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterListMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacter
import com.webslinger.portfolio.moviemania.domain.Character

class CharacterListMapper(private val characterMapper: ICharacterMapper): ICharacterListMapper {
    override fun networkToDbModel(networkCharacters: List<NetworkCharacter>): List<DBCharacterKnownFor> {
        return networkCharacters.map {
            characterMapper.networkToDbModel(it)
        }
    }

    override fun dbToDomainModel(dbCharacters: List<DBCharacterKnownFor>): List<Character> {
        return dbCharacters.map {
            characterMapper.dbToDomainModel(it)
        }
    }
}