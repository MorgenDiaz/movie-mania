package com.webslinger.portfolio.moviemania.data.repository.character.datasource

import com.webslinger.portfolio.moviemania.data.networking.endpoints.CharacterService
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacterList
import com.webslinger.portfolio.moviemania.data.repository.character.idatasource.ICharacterRemoteDataSource
import retrofit2.Response

class CharacterRemoteDataSource(private val characterService: CharacterService, private val apiKey: String):
    ICharacterRemoteDataSource {
    override suspend fun getCharacters(): Response<NetworkCharacterList> = characterService.getPopular(apiKey)
}