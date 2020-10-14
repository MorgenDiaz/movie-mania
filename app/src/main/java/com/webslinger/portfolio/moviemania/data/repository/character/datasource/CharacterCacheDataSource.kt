package com.webslinger.portfolio.moviemania.data.repository.character.datasource

import com.webslinger.portfolio.moviemania.data.repository.character.idatasource.ICharacterCacheDataSource
import com.webslinger.portfolio.moviemania.domain.Character

class CharacterCacheDataSource: ICharacterCacheDataSource {
    private val cachedCharacters: MutableList<Character> = mutableListOf()

    override fun getCharacters(): List<Character> {
        return cachedCharacters
    }

    override fun updateCharacters(characters: List<Character>) {
        cachedCharacters.clear()
        cachedCharacters.addAll(characters)
    }
}