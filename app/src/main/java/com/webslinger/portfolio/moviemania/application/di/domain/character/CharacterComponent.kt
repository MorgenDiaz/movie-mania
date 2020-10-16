package com.webslinger.portfolio.moviemania.application.di.domain.character

import com.webslinger.portfolio.moviemania.presentation.characters.CharactersFragment
import dagger.Subcomponent

@CharactersScope
@Subcomponent(modules = [CharacterModule::class])
interface CharacterComponent {
    fun inject(charactersFragment: CharactersFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): CharacterComponent
    }
}