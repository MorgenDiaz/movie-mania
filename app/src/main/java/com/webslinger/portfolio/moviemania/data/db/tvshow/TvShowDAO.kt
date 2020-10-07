package com.webslinger.portfolio.moviemania.data.db.tvshow

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TvShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<DBTVShow>)

    @Query("DELETE FROM tv_shows_table")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM tv_shows_table")
    fun getAllTvShows(): LiveData<List<DBTVShow>>
}
