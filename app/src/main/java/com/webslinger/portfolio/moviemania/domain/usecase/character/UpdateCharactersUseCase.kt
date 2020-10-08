package com.webslinger.portfolio.moviemania.domain.usecase.character

import com.webslinger.portfolio.moviemania.domain.Character
import com.webslinger.portfolio.moviemania.domain.repository.ICharacterRepository

class UpdateCharactersUseCase(private val characterRepository: ICharacterRepository) {
    suspend fun execute(): List<Character>? = characterRepository.updateCharacters()
}