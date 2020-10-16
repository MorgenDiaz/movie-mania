package com.webslinger.portfolio.moviemania.application.di.domain.character

import com.webslinger.portfolio.moviemania.application.viewmodel.characters.CharacterViewModelFactory
import com.webslinger.portfolio.moviemania.domain.usecase.character.GetCharactersUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.character.UpdateCharactersUseCase
import dagger.Module
import dagger.Provides

@Module
class CharacterModule {
    @Provides
    fun provideCharacterViewModelFactory(
        getCharactersUseCase: GetCharactersUseCase,
        updateCharactersUseCase: UpdateCharactersUseCase
    ): CharacterViewModelFactory{
        return CharacterViewModelFactory(getCharactersUseCase, updateCharactersUseCase)
    }
}