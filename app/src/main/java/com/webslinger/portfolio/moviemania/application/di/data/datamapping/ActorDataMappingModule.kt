package com.webslinger.portfolio.moviemania.application.di.data.datamapping

import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.ActorDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.ActorListMapper
import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.ActorMapper
import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.ActorNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.details.DetailsNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.knownfor.KnownForMapper
import dagger.Module
import dagger.Provides

@Module
class ActorDataMappingModule {
    @Provides
    fun provideActorNetworkToDbMapper(
        knownForMapper: KnownForMapper,
        detailsNetworkToDbMapper: DetailsNetworkToDbMapper
    ): ActorNetworkToDbMapper{
        return ActorNetworkToDbMapper(knownForMapper, detailsNetworkToDbMapper)
    }

    @Provides
    fun provideActorDbToDomainMapper(knownForMapper: KnownForMapper): ActorDbToDomainMapper{
        return ActorDbToDomainMapper(knownForMapper)
    }

    @Provides
    fun provideActorMapper(
        actorNetworkToDbMapper: ActorNetworkToDbMapper,
        characterDbToDomainMapper: ActorDbToDomainMapper
    ): ActorMapper{
        return ActorMapper(actorNetworkToDbMapper, characterDbToDomainMapper)
    }

    @Provides
    fun provideActorListMapper(actorMapper: ActorMapper): ActorListMapper{
        return ActorListMapper(actorMapper)
    }
}