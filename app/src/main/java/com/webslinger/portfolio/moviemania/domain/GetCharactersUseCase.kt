package com.webslinger.portfolio.moviemania.domain

class GetCharactersUseCase(private val characterRepository: ICharacterRepository) {
    suspend fun execute(): List<Character>? = characterRepository.getCharacters()
}