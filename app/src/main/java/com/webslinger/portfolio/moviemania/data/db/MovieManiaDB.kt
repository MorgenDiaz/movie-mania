package com.webslinger.portfolio.moviemania.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.webslinger.portfolio.moviemania.data.db.actor.ActorDAO
import com.webslinger.portfolio.moviemania.data.db.actor.DBActor
import com.webslinger.portfolio.moviemania.data.db.actor.DBActorDetails
import com.webslinger.portfolio.moviemania.data.db.actor.DBKnownFor
import com.webslinger.portfolio.moviemania.data.db.movie.DBMovie
import com.webslinger.portfolio.moviemania.data.db.movie.MovieDAO
import com.webslinger.portfolio.moviemania.data.db.tvshow.DBTvShow
import com.webslinger.portfolio.moviemania.data.db.tvshow.TvShowDAO

@Database(
    entities = [
        DBMovie::class,
        DBTvShow::class,
        DBActor::class,
        DBKnownFor::class,
        DBActorDetails::class
    ],
    version = 2,
    exportSchema = false
)

@TypeConverters(Converters::class)

abstract class MovieManiaDB: RoomDatabase() {
    abstract val movieDAO: MovieDAO
    abstract val tvShowDAO: TvShowDAO
    abstract val actorDAO: ActorDAO

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
                        "movie_mania_db",
                    ).fallbackToDestructiveMigration().build()
                }

                return instance
            }
        }
    }
}
