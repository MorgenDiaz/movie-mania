package com.webslinger.portfolio.moviemania.data.repository.character.idatasource

import com.webslinger.portfolio.moviemania.domain.Character

interface ICharacterCacheDataSource {
    fun getCharacters(): List<Character>
    fun updateCharacters(characters: List<Character>)
}
