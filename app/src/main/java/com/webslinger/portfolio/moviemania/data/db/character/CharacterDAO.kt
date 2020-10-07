package com.webslinger.portfolio.moviemania.data.db.character

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CharacterDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<DBCharacter>)

    fun getAllCharacters(): LiveData<List<DBCharacter>>
}