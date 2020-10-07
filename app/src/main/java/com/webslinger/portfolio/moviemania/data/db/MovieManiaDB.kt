package com.webslinger.portfolio.moviemania.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.webslinger.portfolio.moviemania.data.db.character.CharacterDAO
import com.webslinger.portfolio.moviemania.data.db.movie.MovieDAO
import com.webslinger.portfolio.moviemania.data.db.tvshow.TvShowDAO
import com.webslinger.portfolio.moviemania.data.networking.schema.character.CharacterSchema
import com.webslinger.portfolio.moviemania.data.networking.schema.movie.MovieSchema
import com.webslinger.portfolio.moviemania.data.networking.schema.tvshow.TVShowSchema

@Database(
    entities = [
        MovieSchema::class,
        TVShowSchema::class,
        CharacterSchema::class
    ],
    version = 1,
    exportSchema = false
)

abstract class MovieManiaDB: RoomDatabase() {
    abstract val movieDAO: MovieDAO
    abstract val tvShowDAO: TvShowDAO
    abstract val characterDAO: CharacterDAO

    companion object{
        @Volatile
        private var INSTANCE: MovieManiaDB? = null

        fun getInstance(context: Context): MovieManiaDB{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieManiaDB::class.java,
                        "movie_mania_db"
                    ).build()
                }

                return instance
            }
        }
    }
}
