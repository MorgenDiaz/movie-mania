package com.webslinger.portfolio.moviemania.data.repository.character.idatasource

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor

interface ICharacterLocalDataSource {
    suspend fun saveCharacters(characters: List<DBCharacterKnownFor>)
    suspend fun getCharacters(): List<DBCharacterKnownFor>
    suspend fun clearCharacters()

}
