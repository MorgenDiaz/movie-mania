package com.webslinger.portfolio.moviemania.data.db.character

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class CharacterDAO {
    suspend fun saveCharacters(charactersKnownFor: List<DBCharacterKnownFor>){
        saveBaseCharacters(charactersKnownFor.map { it.character })

        charactersKnownFor.forEach {
            saveKnownFor(it.knownFor)
        }
    }

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun saveBaseCharacters(characters: List<DBCharacter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveKnownFor(knownFor: List<DBKnownFor>)

    @Query("DELETE FROM characters_table")
    abstract suspend fun deleteAllCharacters()

    @Transaction
    @Query("SELECT * FROM characters_table")
    abstract fun getAllCharacters(): List<DBCharacterKnownFor>
}