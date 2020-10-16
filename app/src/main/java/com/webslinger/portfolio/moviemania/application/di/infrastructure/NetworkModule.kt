package com.webslinger.portfolio.moviemania.application.di.infrastructure

import com.webslinger.portfolio.moviemania.data.networking.TheMovieDbRetrofitServerProducer
import com.webslinger.portfolio.moviemania.data.networking.endpoints.CharacterService
import com.webslinger.portfolio.moviemania.data.networking.endpoints.MovieService
import com.webslinger.portfolio.moviemania.data.networking.endpoints.TvShowService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideTMDBRetrofitServer(): Retrofit{
        return TheMovieDbRetrofitServerProducer.produceNew()
    }

    @Singleton
    @Provides
    fun provideMovieService(tmdbRetrofitServer: Retrofit): MovieService{
        return tmdbRetrofitServer.create(MovieService::class.java)
    }

    @Singleton
    @Provides
    fun provideTvShowService(tmdbRetrofitServer: Retrofit): TvShowService{
        return tmdbRetrofitServer.create(TvShowService::class.java)
    }

    @Singleton
    @Provides
    fun provideCharacterService(tmdbRetrofitServer: Retrofit): CharacterService{
        return tmdbRetrofitServer.create(CharacterService::class.java)
    }


}