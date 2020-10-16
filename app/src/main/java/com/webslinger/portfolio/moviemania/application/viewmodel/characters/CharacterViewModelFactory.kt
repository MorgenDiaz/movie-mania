package com.webslinger.portfolio.moviemania.application.viewmodel.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.webslinger.portfolio.moviemania.domain.usecase.character.GetCharactersUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.character.UpdateCharactersUseCase

class CharacterViewModelFactory(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val updateCharactersUseCase: UpdateCharactersUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CharactersViewModel::class.java)){
            return CharactersViewModel(getCharactersUseCase, updateCharactersUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class.")
    }
}