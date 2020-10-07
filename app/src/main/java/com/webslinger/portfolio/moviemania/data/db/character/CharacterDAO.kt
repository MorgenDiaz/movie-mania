package com.webslinger.portfolio.moviemania.data.db.character

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(characters: List<DBCharacter>)

    @Query("DELETE FROM characters_table")
    suspend fun deleteAllCharacters()

    @Query("SELECT * FROM characters_table")
    fun getAllCharacters(): LiveData<List<DBCharacter>>
}