package com.webslinger.portfolio.moviemania.application.di.data.datamapping

import com.webslinger.portfolio.moviemania.data.repository.movie.datamapping.MovieDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.movie.datamapping.MovieListMapper
import com.webslinger.portfolio.moviemania.data.repository.movie.datamapping.MovieMapper
import com.webslinger.portfolio.moviemania.data.repository.movie.datamapping.MovieNetworkToDbMapper
import dagger.Module
import dagger.Provides

@Module
class MovieDataMappingModule {
    @Provides
    fun provideMovieNetworkToDbMapper(): MovieNetworkToDbMapper{
        return MovieNetworkToDbMapper()
    }

    @Provides
    fun provideMovieDbToDomainMapper(): MovieDbToDomainMapper{
        return MovieDbToDomainMapper()
    }

    @Provides
    fun provideMovieMapper(
        networkToDbMapper: MovieNetworkToDbMapper,
        dbToDomainMapper: MovieDbToDomainMapper
    ): MovieMapper{
        return MovieMapper(networkToDbMapper, dbToDomainMapper)
    }

    @Provides
    fun provideMovieListMapper(movieMapper: MovieMapper): MovieListMapper{
        return MovieListMapper(movieMapper)
    }
}