package com.webslinger.portfolio.moviemania.data.repository.character.idatasource

import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacterList
import retrofit2.Response

interface ICharacterRemoteDataSource {
    suspend fun getCharacters(): Response<NetworkCharacterList>
}
