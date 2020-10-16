package com.webslinger.portfolio.moviemania.application.viewmodel.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.webslinger.portfolio.moviemania.domain.Character
import com.webslinger.portfolio.moviemania.domain.usecase.character.GetCharactersUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.character.UpdateCharactersUseCase

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val updateCharactersUseCase: UpdateCharactersUseCase
) : ViewModel() {

    fun getCharacters(): LiveData<List<Character>?>{
        return liveData {
            val characters = getCharactersUseCase.execute()
            emit(characters)
        }
    }

    fun updateCharacters(): LiveData<List<Character>?>{
        return liveData {
            val characters = updateCharactersUseCase.execute()
            emit(characters)
        }
    }
}