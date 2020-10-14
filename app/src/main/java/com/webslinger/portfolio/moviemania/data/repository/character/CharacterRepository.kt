package com.webslinger.portfolio.moviemania.data.repository.character

import android.util.Log
import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterListMapper
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacter
import com.webslinger.portfolio.moviemania.data.repository.character.idatasource.ICharacterLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.idatasource.ICharacterRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.idatasource.ICharacterCacheDataSource
import com.webslinger.portfolio.moviemania.domain.Character
import com.webslinger.portfolio.moviemania.domain.repository.ICharacterRepository

class CharacterRepository(
    private val remoteDataSource: ICharacterRemoteDataSource,
    private val localDataSource: ICharacterLocalDataSource,
    private val cacheDataSource: ICharacterCacheDataSource,
    private val characterListMapper: ICharacterListMapper
): ICharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        val cachedCharacters = cacheDataSource.getCharacters()

        if(cachedCharacters.isEmpty()){
            val dbCharacters = getCharactersFromDb()

            if(dbCharacters.isEmpty()){
                downloadCharacters()
                return cacheDataSource.getCharacters()
            }

            cacheDataSource.updateCharacters(dbCharacters)
            return dbCharacters
        }

        return cachedCharacters
    }

    override suspend fun updateCharacters(): List<Character> {
        downloadCharacters()
        return cacheDataSource.getCharacters()
    }

    private suspend fun downloadCharacters(){
        val networkCharacters = getCharactersFromNetwork()

        val dbCharacters = characterListMapper.networkToDbModel(networkCharacters)
        localDataSource.saveCharacters(dbCharacters)

        val characters = characterListMapper.dbToDomainModel(dbCharacters)
        cacheDataSource.updateCharacters(characters)
    }

    private suspend fun getCharactersFromNetwork(): List<NetworkCharacter>{
        var networkCharacters: List<NetworkCharacter> = listOf()

        try {
            val response = remoteDataSource.getCharacters()
            val responseBody = response.body()

            responseBody?.let {
                networkCharacters = it.networkCharacters
            }
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error downloading characters from network.")
        }

        return networkCharacters
    }

    private suspend fun getCharactersFromDb(): List<Character>{
        var characters: List<Character> = listOf()

        try {
            val dbCharacters = localDataSource.getCharacters()
            characters = characterListMapper.dbToDomainModel(dbCharacters)
        }
        catch (e: Exception){
            Log.i("MovieMania", "Error retrieving characters from database.")
        }

        return characters
    }
}