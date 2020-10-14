package com.webslinger.portfolio.moviemania.data.datamapping.character

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacter
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacter
import com.webslinger.portfolio.moviemania.domain.Character

interface ICharacterListMapper {
    fun networkToDbModel(networkCharacters: List<NetworkCharacter>): List<DBCharacterKnownFor>
    fun dbToDomainModel(dbCharacters: List<DBCharacterKnownFor>): List<Character>
}