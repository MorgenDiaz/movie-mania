package com.webslinger.portfolio.moviemania.domain

class UpdateCharactersUseCase(private val characterRepository: ICharacterRepository) {
    suspend fun execute(): List<Character>? = characterRepository.updateCharacters()
}