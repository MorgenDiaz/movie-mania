package com.webslinger.portfolio.moviemania.data.repository.character.datasource

import com.webslinger.portfolio.moviemania.data.db.character.CharacterDAO
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.repository.character.idatasource.ICharacterLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterLocalDataSource(private val characterDAO: CharacterDAO): ICharacterLocalDataSource {
    override suspend fun saveCharacters(characters: List<DBCharacterKnownFor>) {
        CoroutineScope(Dispatchers.IO).launch {
            characterDAO.saveCharacters(characters)
        }
    }

    override suspend fun getCharacters(): List<DBCharacterKnownFor> {
        return characterDAO.getAllCharacters()
    }

    override suspend fun clearCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            characterDAO.deleteAllCharacters()
        }
    }
}