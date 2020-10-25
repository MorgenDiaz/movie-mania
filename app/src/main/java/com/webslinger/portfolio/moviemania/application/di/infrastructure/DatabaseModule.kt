package com.webslinger.portfolio.moviemania.application.di.infrastructure

import android.content.Context
import com.webslinger.portfolio.moviemania.data.db.MovieManiaDB
import com.webslinger.portfolio.moviemania.data.db.actor.ActorDAO
import com.webslinger.portfolio.moviemania.data.db.movie.MovieDAO
import com.webslinger.portfolio.moviemania.data.db.tvshow.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieManiaDatabase(context: Context): MovieManiaDB{
        return MovieManiaDB.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideMovieDAO(movieManiaDB: MovieManiaDB): MovieDAO{
        return movieManiaDB.movieDAO
    }

    @Singleton
    @Provides
    fun provideTvShowDAO(movieManiaDB: MovieManiaDB): TvShowDAO{
        return movieManiaDB.tvShowDAO
    }

    @Singleton
    @Provides
    fun provideActorDAO(movieManiaDB: MovieManiaDB):ActorDAO{
        return movieManiaDB.actorDAO
    }

}