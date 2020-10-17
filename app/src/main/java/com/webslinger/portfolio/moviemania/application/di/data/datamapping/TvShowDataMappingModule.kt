package com.webslinger.portfolio.moviemania.application.di.data.datamapping

import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowListMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowNetworkToDbMapper
import dagger.Module
import dagger.Provides

@Module
class TvShowDataMappingModule {
    @Provides
    fun provideTvShowNetworkToDbMapper(): TvShowNetworkToDbMapper{
        return TvShowNetworkToDbMapper()
    }

    @Provides
    fun provideTvShowDbToDomainMapper(): TvShowDbToDomainMapper{
        return TvShowDbToDomainMapper()
    }

    @Provides
    fun provideTvShowMapper(
        tvShowNetworkToDbMapper: TvShowNetworkToDbMapper,
        tvShowDbToDomainMapper: TvShowDbToDomainMapper
    ): TvShowMapper{
        return TvShowMapper(tvShowNetworkToDbMapper, tvShowDbToDomainMapper)
    }

    @Provides
    fun provideTvShowListMapper(tvShowMapper: TvShowMapper): TvShowListMapper{
        return TvShowListMapper(tvShowMapper)
    }
}