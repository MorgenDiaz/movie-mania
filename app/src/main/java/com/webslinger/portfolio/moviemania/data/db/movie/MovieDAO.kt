package com.webslinger.portfolio.moviemania.data.db.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<DBMovie>)

    fun getAllMovies(): LiveData<List<DBMovie>>
}