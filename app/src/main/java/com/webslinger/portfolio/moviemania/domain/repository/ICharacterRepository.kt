package com.webslinger.portfolio.moviemania.domain.repository

import com.webslinger.portfolio.moviemania.domain.Character

interface ICharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun updateCharacters(): List<Character>
}
