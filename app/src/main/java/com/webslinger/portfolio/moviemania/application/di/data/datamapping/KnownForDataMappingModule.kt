package com.webslinger.portfolio.moviemania.application.di.data.datamapping

import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForNetworkToDbMapper
import dagger.Module
import dagger.Provides

@Module
class KnownForDataMappingModule {
    @Provides
    fun provideKnownForNetworkToDbMapper(): KnownForNetworkToDbMapper{
        return KnownForNetworkToDbMapper()
    }

    @Provides
    fun provideKnownForDbToDomainMapper(): KnownForDbToDomainMapper{
        return KnownForDbToDomainMapper()
    }

    @Provides
    fun provideKnownForMapper(
        knownForNetworkToDbMapper: KnownForNetworkToDbMapper,
        knownForDbToDomainMapper: KnownForDbToDomainMapper
    ): KnownForMapper{
        return KnownForMapper(knownForNetworkToDbMapper, knownForDbToDomainMapper)
    }
}