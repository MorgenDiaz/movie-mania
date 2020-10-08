package com.webslinger.portfolio.moviemania.domain

interface ICharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun updateCharacters(): List<Character>
}
