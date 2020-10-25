package com.webslinger.portfolio.moviemania.application.di.data.datamapping

import com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.details.DetailsNetworkToDbMapper
import dagger.Module
import dagger.Provides

@Module
class DetailsDataMappingModule {
    @Provides
    fun provideDetailsNetworkToDbMapper():DetailsNetworkToDbMapper{
        return DetailsNetworkToDbMapper()
    }
}