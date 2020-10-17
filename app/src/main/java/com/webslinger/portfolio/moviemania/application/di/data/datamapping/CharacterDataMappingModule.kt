package com.webslinger.portfolio.moviemania.application.di.data.datamapping

import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterListMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForMapper
import dagger.Module
import dagger.Provides

@Module
class CharacterDataMappingModule {
    @Provides
    fun provideCharacterNetworkToDbMapper(knownForMapper: KnownForMapper): CharacterNetworkToDbMapper{
        return CharacterNetworkToDbMapper(knownForMapper)
    }

    @Provides
    fun provideCharacterDbToDomainMapper(knownForMapper: KnownForMapper): CharacterDbToDomainMapper{
        return CharacterDbToDomainMapper(knownForMapper)
    }

    @Provides
    fun provideCharacterMapper(
        characterNetworkToDbMapper: CharacterNetworkToDbMapper,
        characterDbToDomainMapper: CharacterDbToDomainMapper
    ): CharacterMapper{
        return CharacterMapper(characterNetworkToDbMapper, characterDbToDomainMapper)
    }

    @Provides
    fun provideCharacterListMapper(characterMapper: CharacterMapper): CharacterListMapper{
        return CharacterListMapper(characterMapper)
    }
}