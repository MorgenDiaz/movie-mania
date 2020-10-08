package com.webslinger.portfolio.moviemania.data.db.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<DBMovie>)

    @Query("DELETE FROM movies_table")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMovies(): List<DBMovie>
}