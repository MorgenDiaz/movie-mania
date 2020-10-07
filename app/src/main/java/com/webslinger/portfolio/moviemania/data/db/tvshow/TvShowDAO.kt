package com.webslinger.portfolio.moviemania.data.db.tvshow

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TvShowDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShows(tvShows: List<DBTVShow>)

    fun getAllTvShows(): LiveData<List<DBTVShow>>
}
