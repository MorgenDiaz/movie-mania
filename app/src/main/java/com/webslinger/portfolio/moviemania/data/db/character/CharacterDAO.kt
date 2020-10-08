package com.webslinger.portfolio.moviemania.data.db.character

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class CharacterDAO {
    suspend fun saveCharactersAndKnownFor(charactersKnownFor: List<DBCharacterKnownFor>){
        saveCharacters(charactersKnownFor.map { it.character })

        charactersKnownFor.forEach {
            saveKnownFor(it.knownFor)
        }
    }

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveCharacters(characters: List<DBCharacter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveKnownFor(knownFor: List<DBKnownFor>)

    @Query("DELETE FROM characters_table")
    abstract suspend fun deleteAllCharacters()

    @Transaction
    @Query("SELECT * FROM characters_table")
    abstract fun getAllCharacters(): LiveData<List<DBCharacterKnownFor>>
}